package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Order;
import com.learn.microservices.supermarket.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private RandomService randomService;

    @Autowired
    public OrderServiceImpl(@Qualifier("RandomProduct") RandomService randomService) {
        this.randomService = randomService;
    }

    @Override
    public Order build() {
        List<Product> products = new ArrayList<>();

        Product p1 = (Product) randomService.generate();
        products.add(p1);

        return new Order(products);
    }

    @Override
    public Order filter(List<Predicate> filters) {
        List<Product> products = new ArrayList<>();

        Product p1 = (Product) randomService.generate();
        Product p2 = (Product) randomService.generate();
        Product p3 = (Product) randomService.generate();

        products.add(p1);
        products.add(p2);
        products.add(p3);

        List<Product> productsFiltered = (List<Product>) products.stream()
                .filter(filters.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());

        return new Order(productsFiltered);
    }
}
