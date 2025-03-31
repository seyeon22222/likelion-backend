package com.inspire12.likelionbackend.module.core.properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

// @Configuration
// @Getter
// public class CustomEnvProperties {
//     @Value("${custom.env}")
//     private String env;
//
// }

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "custom")
public class CustomEnvProperties {
	private String env;

}