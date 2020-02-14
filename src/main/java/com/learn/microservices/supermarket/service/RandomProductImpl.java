package com.learn.microservices.supermarket.service;

import com.learn.microservices.supermarket.domain.Product;
import com.learn.microservices.supermarket.utils.Tuple;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component("RandomProduct")
public class RandomProductImpl implements RandomService<Product> {

    private List<String> names = Arrays.asList("FastFood", "SoftDrink", "AlcoholDrink", "Pasta");
    private List<List<Tuple<String, BigDecimal>>> descriptions = Arrays.asList(
            Arrays.asList(
              new Tuple<String, BigDecimal>("Burguer", new BigDecimal("5.0")),
              new Tuple<String, BigDecimal>("Fish&Chips", new BigDecimal("6.4")),
              new Tuple<String, BigDecimal>("Pizza", new BigDecimal("7.0"))
            ),
            Arrays.asList(
                new Tuple<String, BigDecimal>("Coke", new BigDecimal("1.0")),
                new Tuple<String, BigDecimal>("Soda", new BigDecimal("1.0")),
                new Tuple<String, BigDecimal>("Lemon Juice", new BigDecimal("1.0"))
            ),
            Arrays.asList(
                    new Tuple<String, BigDecimal>("Beer", new BigDecimal("4.0")),
                    new Tuple<String, BigDecimal>("Red Wine", new BigDecimal("27.5")),
                    new Tuple<String, BigDecimal>("White Wine", new BigDecimal("27.5"))
            ),
            Arrays.asList(
                    new Tuple("Spaguetti", new BigDecimal("9.4")),
                    new Tuple("Maccarroni", new BigDecimal("6.5"))
            )
    );
    private Map<String, List<Tuple<String, BigDecimal>>> nameDesc = IntStream
            .range(0, names.size())
            .boxed()
            .collect(
                    Collectors.toMap(
                            i -> names.get(i),
                            i -> descriptions.get(i)
                    )
            );

    @Override
    public Product generate() {
        int idx = new Random().nextInt(names.size());
        String name = names.get(idx);
        List<Tuple<String, BigDecimal>> values = nameDesc.get(name);
        int idx2 = new Random().nextInt(values.size());
        return new Product(
                name,
                values.get(idx2).getLeft(), // description
                values.get(idx2).getRight() // price
        );
    }
}
