package com.inspire12.likelionbackend.config.core;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class TransactionExecutor {
    private final TransactionTemplate transactionTemplate;

    public TransactionExecutor(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public <T> T executeInTransaction(ExecuteService<T> service) {
        return transactionTemplate.execute(status -> {
            try {
                return service.execute();
            } catch (Exception e) {
                status.setRollbackOnly();
                throw e;
            }
        });
    }
}
