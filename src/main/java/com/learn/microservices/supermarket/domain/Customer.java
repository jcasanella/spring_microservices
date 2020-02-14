package com.learn.microservices.supermarket.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@RequiredArgsConstructor
public final class Customer {

    private final String name;
    private final String surname;
    private final String address;

    public Customer() {
        this.name = null;
        this.surname = null;
        this.address = null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Customer)) return false;

        Customer c = (Customer) o;
        return name.equals(c.getName()) &&
                surname.equals(c.getSurname()) &&
                address.equals(c.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address);
    }
}
