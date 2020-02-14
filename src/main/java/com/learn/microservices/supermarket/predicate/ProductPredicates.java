package com.learn.microservices.supermarket.predicate;

import com.learn.microservices.supermarket.domain.Product;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class ProductPredicates {
    public static Predicate<Product> isPriceBiggerThan(BigDecimal price) {
        return p -> p.getPrice().compareTo(price) > 0;
    }

    public static Predicate<Product> isPriceLessThan(BigDecimal price) {
        return p -> p.getPrice().compareTo(price) < 0;
    }

    public static Predicate<Product> isNameStarting(String cad1) {
        return p -> p.getName().startsWith(cad1);
    }

    public static Predicate<Product> isDescriptionStarting(String cad1) {
        return p -> p.getDescription().startsWith(cad1);
    }
}
