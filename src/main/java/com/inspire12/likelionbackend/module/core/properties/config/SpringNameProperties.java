package com.inspire12.likelionbackend.module.core.properties.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(
        prefix = "spring",
        ignoreUnknownFields = true
)
@Getter
@Setter // 필요
public class SpringNameProperties {

    private ApplicationName application;

    @Getter
    @Setter
    public static class ApplicationName {
        String name;
    }
}
