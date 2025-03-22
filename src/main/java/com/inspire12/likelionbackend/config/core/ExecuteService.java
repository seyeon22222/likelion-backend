package com.inspire12.likelionbackend.config.core;

@FunctionalInterface
public interface ExecuteService<T> {
    T execute();
}
