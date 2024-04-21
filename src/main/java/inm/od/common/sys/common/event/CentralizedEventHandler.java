package inm.od.common.sys.common.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

@Component
public class CentralizedEventHandler {

    private List<PlatformTransactionManager> transactionManagers;

    public CentralizedEventHandler(List<PlatformTransactionManager> transactionManagers) {
        this.transactionManagers = transactionManagers;
    }

    public void processEvent(DataSourceEvent event, List<DataSourceOperation> operations) {
        if (operations.size() != transactionManagers.size()) {
            throw new IllegalArgumentException("The number of operations must match the number of transaction managers.");
        }

        List<TransactionStatus> statuses = new ArrayList<>();
        try {
            // Start transactions for all data sources
            for (int i = 0; i < transactionManagers.size(); i++) {
                statuses.add(transactionManagers.get(i).getTransaction(new DefaultTransactionDefinition()));
            }

            // Execute operations for all data sources
            for (int i = 0; i < operations.size(); i++) {
                operations.get(i).execute();
            }

            // Commit all transactions
            for (TransactionStatus status : statuses) {
                transactionManagers.get(statuses.indexOf(status)).commit(status);
            }
        } catch (Exception ex) {
            // Rollback all transactions if any operation fails
            for (TransactionStatus status : statuses) {
                if (!status.isCompleted()) {
                    transactionManagers.get(statuses.indexOf(status)).rollback(status);
                }
            }
            throw new RuntimeException("Failed to execute transaction", ex);
        }
    }
}
