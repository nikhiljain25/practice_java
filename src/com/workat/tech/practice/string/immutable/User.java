package com.workat.tech.practice.string.immutable;

public class User {
    private final int id;
    private final String name;
    private final Address address;

    public User(int id, String name, Address address) {
        this.name = name;
        this.id = id;
        // Use a copy of the Address object to ensure immutability
        this.address = new Address(address);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        // Return a copy of the Address object to ensure immutability
        return new Address(address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
