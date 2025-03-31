package com.inspire12.likelionbackend.module.core.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// @Configuration
// @Getter
// public class ServerPortProperties {
//     @Value("${server.port}")
//     private String port;
// }

@Getter
@Setter
@ConfigurationProperties(prefix = "port")
@Configuration
public class ServerPortProperties {
    private String port;
}