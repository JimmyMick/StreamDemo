package com.example.util;

@FunctionalInterface
public interface Calculator<T, R> {
    public int sum(T a, R b);
}
