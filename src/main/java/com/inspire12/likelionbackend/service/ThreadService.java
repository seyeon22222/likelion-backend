package com.inspire12.likelionbackend.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;



@RequiredArgsConstructor
@Service
public class ThreadService {
    private final @Qualifier("customThreadPoolExecutor") Executor executor;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public void executeThreads() {
        Runnable runnable = () -> {
            try {
                log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
                Thread.sleep(1000); // 1초간 정지
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 10; i++) {
            executor.execute(runnable);
        }
    }
}
