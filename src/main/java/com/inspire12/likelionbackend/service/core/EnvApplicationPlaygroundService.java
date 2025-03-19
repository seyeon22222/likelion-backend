package com.inspire12.likelionbackend.service.core;

import com.inspire12.likelionbackend.config.CustomEnvProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnvApplicationPlaygroundService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final CustomEnvProperties customEnvProperties;

    @Value("${custom.env}")
    private String env;

    public String hello() {

        log.info("env : {}", env);
        log.info("env : {}", customEnvProperties.getEnv());
        return customEnvProperties.getEnv();
    }

}
