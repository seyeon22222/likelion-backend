package com.inspire12.likelionbackend.config;

@FunctionalInterface
public interface ExecuteService<T> {
    T execute();
}
