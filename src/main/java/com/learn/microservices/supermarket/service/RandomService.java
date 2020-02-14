package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Product;

public interface RandomService<T> {

    /**
     * Generate a {@link Product}
     *
     * @return a randomly Product
     */
    public T generate();
}
