package com.inspire12.likelionbackend.module.core.properties.service;

import com.inspire12.likelionbackend.module.core.properties.config.CustomEnvProperties;
import com.inspire12.likelionbackend.module.core.properties.config.SpringNameProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnvApplicationPlaygroundService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final CustomEnvProperties customEnvProperties;
    private final SpringNameProperties springNameProperties;

    @Value("${custom.env}")
    private String env;

    public EnvApplicationPlaygroundService(CustomEnvProperties customEnvProperties, SpringNameProperties springNameProperties) {
        this.customEnvProperties = customEnvProperties;
        this.springNameProperties = springNameProperties;
    }

    public String getCustomValue() {

        log.info("env : {}", env);
        log.info("env : {}", customEnvProperties.getEnv());
        return customEnvProperties.getEnv();
    }


    public String getApplicationName() {

        log.info("env : {}", env);
        log.info("env : {}", springNameProperties.getApplication().getName());
        return springNameProperties.getApplication().getName();
    }

}
