package com.inspire12.likelionbackend.module.jpa.config;

@FunctionalInterface
public interface ExecuteService<T> {
    T execute();
}
