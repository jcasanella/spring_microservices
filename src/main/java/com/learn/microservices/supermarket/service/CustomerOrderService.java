package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.CustomerOrder;

public interface CustomerOrderService {
    /**
     * Build a {@link CustomerOrder} where Customer and Products are build random
     *
     * @return a randomly CustomerProducts
     */
    CustomerOrder build();
}
