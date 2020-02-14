package com.learn.microservices.supermarket;

import com.learn.microservices.supermarket.domain.Order;
import com.learn.microservices.supermarket.service.OrderService;
import com.learn.microservices.supermarket.service.OrderServiceImpl;
import com.learn.microservices.supermarket.service.RandomProductImpl;
import com.learn.microservices.supermarket.service.RandomService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderServiceTest {
    private OrderService orderService;

    @Before
    public void setUp() {
        RandomService randomService = new RandomProductImpl();
        orderService = new OrderServiceImpl(randomService);
    }

    @Test
    public void createRandomOrder() {
        Order order = orderService.build();

        System.out.println(order.toString());

        assertTrue("Order has some products", !order.getProducts().isEmpty());
    }
}
