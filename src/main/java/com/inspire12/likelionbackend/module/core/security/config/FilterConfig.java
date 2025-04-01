package com.inspire12.likelionbackend.module.core.security.config;

import com.inspire12.likelionbackend.module.core.threadlocal.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilterRegistration() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthFilter());
        registrationBean.addUrlPatterns("/*"); // 모든 URL에 적용
        registrationBean.setOrder(1);          // 필터 실행 순서 지정 가능

        return registrationBean;
    }
}
