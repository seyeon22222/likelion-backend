package com.inspire12.likelionbackend.module.core.ioc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BeanService {

    @Bean
    public CustomSimpleService customService() {
        return new CustomSimpleService();
    }
}
