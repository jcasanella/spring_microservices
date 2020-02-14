package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Order;

import java.util.List;
import java.util.function.Predicate;

public interface OrderService {
    /**
     * Build an {@link Order} with different products and calculate the price
     *
     * @return an object Order with the list of products and total price
     */
    Order build();

    /**
     * Filter an {@link Order} using different predicates
     *
     * @return an object Order filtered out
     */
    Order filter(List<Predicate> filters);
}
