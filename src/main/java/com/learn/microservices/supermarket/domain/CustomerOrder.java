package com.learn.microservices.supermarket.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@RequiredArgsConstructor
public class CustomerOrder {

    private final Customer customer;
    private final Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrder)) return false;

        CustomerOrder co = (CustomerOrder) o;
        return customer.equals(co.getCustomer()) &&
                order.equals(co.getOrder());
    }
}
