package com.inspire12.likelionbackend.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(
        prefix = "custom",
        ignoreUnknownFields = true
)
@Getter
@Setter // 필요
public class CustomEnvProperties {
    private String env;
}
