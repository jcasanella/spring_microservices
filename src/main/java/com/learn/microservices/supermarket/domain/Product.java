package com.learn.microservices.supermarket.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter @Setter
@ToString
public class Product {

    private @Setter(AccessLevel.NONE) UUID idProduct;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
        this.idProduct = UUID.randomUUID();
        this.name = null;
        this.description = null;
        this.price = BigDecimal.ZERO;
    }

    public Product(String name, String description, BigDecimal price) {
        this.idProduct = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product p = (Product) o;
        return name.equals(p.getName()) &&
                description.equals(p.getDescription()) &&
                (price.compareTo(p.getPrice()) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
