package inm.od.biz.service;

import inm.od.biz.controller.ViewController;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Log4j2
public class MemberService {

    private TransactionTemplate transactionTemplate;

    private PlatformTransactionManager transactionManager1;
    private PlatformTransactionManager transactionManager2;


    public String getMember() {

        transactionTemplate = new TransactionTemplate();

        transactionTemplate.setTransactionManager(transactionManager1);
        transactionTemplate.setTransactionManager(transactionManager2);

        transactionTemplate.execute(status -> {
            try {
                log.info("transactionTemplate execute");

                if (status.isCompleted()) {
                    log.info("status.isCompleted");
                    transactionManager1.commit(status);
                    transactionManager2.commit(status);
                }

                return null;
            } catch (Exception e) {
                transactionManager1.rollback(status);
                transactionManager2.rollback(status);
                return null;
            }

        });

        String s = ViewController.threadLocal.get();
        log.info("getMember: {}", s);
        return "getMember";
    }
}
