package inm.od.common.sys.common.tran;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class TransactionAspect {

    @Autowired
    private PlatformTransactionManager transactionManager1;

    @Autowired
    private PlatformTransactionManager transactionManager2;

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalMethods() {}

    @Around("transactionalMethods() && args(callback)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint, TransactionCallback<?> callback) throws Throwable {
        TransactionStatus status1 = transactionManager1.getTransaction(new DefaultTransactionDefinition());
        TransactionStatus status2 = transactionManager2.getTransaction(new DefaultTransactionDefinition());

        try {
            Object result = joinPoint.proceed();
            transactionManager1.commit(status1);
            transactionManager2.commit(status2);
            return result;
        } catch (Exception ex) {
            transactionManager1.rollback(status1);
            transactionManager2.rollback(status2);
            throw ex;
        }
    }
}