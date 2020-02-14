package com.learn.microservices.supermarket;

import com.learn.microservices.supermarket.domain.Order;
import com.learn.microservices.supermarket.domain.Product;
import com.learn.microservices.supermarket.service.OrderService;
import com.learn.microservices.supermarket.service.OrderServiceImpl;
import com.learn.microservices.supermarket.service.RandomService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class OrderServiceMockTest {
    private OrderService orderService;

    @Mock
    private RandomService randomProductService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        orderService = new OrderServiceImpl(randomProductService);
    }

    @Test
    public void createRandomOrder() {
        // Given
        given(randomProductService.generate())
                .willReturn(new Product("name1", "product1", new BigDecimal(5)));

        // When
        Order order = orderService.build();

        // Assert
        assertThat(order.getProducts().size()).isEqualTo(1);
    }
}
