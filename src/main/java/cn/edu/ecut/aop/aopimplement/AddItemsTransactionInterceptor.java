package cn.edu.ecut.aop.aopimplement;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
@Aspect
public class AddItemsTransactionInterceptor
{
    @Autowired
    @Qualifier("transactionManager")
    private PlatformTransactionManager transactionManager1;

    @Autowired
    @Qualifier("peopleTransactionManager")
    private PlatformTransactionManager transactionManager2;

    @Pointcut(value = "execution(void addItems(..))")
    public void addItemsPointcut(){};

    @Around(value = "addItemsPointcut()")
    public void interceptor(ProceedingJoinPoint joinPoint)
    {
        TransactionDefinition definition=new DefaultTransactionDefinition();
        TransactionStatus status1=transactionManager1.getTransaction(definition);
        TransactionStatus status2=transactionManager2.getTransaction(definition);
        try
        {
            joinPoint.proceed();

            transactionManager2.commit(status2);
            transactionManager1.commit(status1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            transactionManager1.rollback(status1);
            transactionManager2.rollback(status2);
        }
    }
}
