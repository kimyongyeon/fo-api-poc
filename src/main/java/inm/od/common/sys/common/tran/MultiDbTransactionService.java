package inm.od.common.sys.common.tran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class MultiDbTransactionService {
    @Autowired
    private PlatformTransactionManager transactionManager1;

    @Autowired
    private PlatformTransactionManager transactionManager2;

    public void updateBothDatabasesAtomically() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status1 = transactionManager1.getTransaction(def);
        TransactionStatus status2 = transactionManager2.getTransaction(def);

        try {
            // 데이터베이스 1 업데이트 로직
            // 예: update db1 set ...

            // 데이터베이스 2 업데이트 로직
            // 예: update db2 set ...

            transactionManager1.commit(status1);
            transactionManager2.commit(status2);
        } catch (Exception ex) {
            transactionManager1.rollback(status1);
            transactionManager2.rollback(status2);
            throw ex;
        }
    }
}
