package com.inspire12.likelionbackend.module.mvc.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.inspire12.likelionbackend.module.mvc.model.Customer;

public class OrderArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // TODO
        return parameter.getParameterType().equals(Customer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//       TODO
        Long customerId = Long.parseLong(webRequest.getHeader("user-id"));
        return new Customer(customerId);
    }
}
