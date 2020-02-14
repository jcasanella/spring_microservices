package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Customer;
import org.springframework.stereotype.Component;

@Component("RandomCustomer")
public class RandomCustomerImpl implements RandomService<Customer> {

    @Override
    public Customer generate() {
        return null;
    }
}
