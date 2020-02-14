package com.learn.microservices.supermarket.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter @Setter
public class Order {

    private @Setter(AccessLevel.NONE) UUID idOrder;
    private List<Product> products;
    private @Setter(AccessLevel.NONE) BigDecimal total;

    public Order() {
        this.idOrder = UUID.randomUUID();
        this.products = new ArrayList<>();
    }

    public Order(List<Product> product) {
        this.idOrder = UUID.randomUUID();
        this.products = new ArrayList<>(product);
        this.total = this.products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;
        return products.stream()
                .allMatch(order.getProducts()::contains) &&
                total.compareTo(((Order) o).getTotal()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, total);
    }

    @Override
    public String toString() {
        String elemsTotal = String.format("List of products have %d elements and the total sum is %s", products.size(),
                total.setScale(2).toString());

        String listProducts = products.stream()
                .map(Product::toString)
                .collect(Collectors.joining());

        return elemsTotal + '\n' + listProducts;
    }

}
