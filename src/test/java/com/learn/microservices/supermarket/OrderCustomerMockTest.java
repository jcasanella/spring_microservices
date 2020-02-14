package com.learn.microservices.supermarket;

import com.learn.microservices.supermarket.domain.Customer;
import com.learn.microservices.supermarket.domain.CustomerOrder;
import com.learn.microservices.supermarket.domain.Product;
import com.learn.microservices.supermarket.service.CustomerOrderImpl;
import com.learn.microservices.supermarket.service.CustomerOrderService;
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

public class OrderCustomerMockTest {
    private CustomerOrderService customerOrderService;

    @Mock
    private RandomService randomCustomer;

    @Mock
    private RandomService randomProduct;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        customerOrderService = new CustomerOrderImpl(randomCustomer, randomProduct);
    }

    @Test
    public void generateRandomCustomerOrder() {
        // Given
        given(randomCustomer.generate()).willReturn(new Customer("name1", "surname1",
                "address1"));

        given(randomProduct.generate()).willReturn(new Product("name1", "product1", BigDecimal.ONE));

        // When
        CustomerOrder customerOrder = customerOrderService.build();
        System.out.println(customerOrder.toString());

        // Assert
        assertThat(customerOrder.getCustomer() != null);
    }
}
