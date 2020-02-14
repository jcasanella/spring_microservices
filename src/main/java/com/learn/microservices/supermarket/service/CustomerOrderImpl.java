package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Customer;
import com.learn.microservices.supermarket.domain.CustomerOrder;
import com.learn.microservices.supermarket.domain.Order;
import com.learn.microservices.supermarket.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerOrderImpl implements CustomerOrderService {

    private RandomService randomCustomer;
    private RandomService randomProduct;

    @Autowired
    public CustomerOrderImpl(@Qualifier("RandomCustomer") RandomService randomCustomer,
                             @Qualifier("RandomProduct") RandomService randomProduct) {
        this.randomCustomer = randomCustomer;
        this.randomProduct = randomProduct;
    }


    @Override
    public CustomerOrder build() {
        Customer cust = (Customer) this.randomCustomer.generate();

        List<Product> products = new ArrayList<>();
        products.addAll(
            IntStream.range(0, 10)
                    .mapToObj(i -> (Product) randomProduct.generate())
                    .collect(Collectors.toList())
        );

        Order order = new Order(products);

        return new CustomerOrder(cust, order);
    }
}
