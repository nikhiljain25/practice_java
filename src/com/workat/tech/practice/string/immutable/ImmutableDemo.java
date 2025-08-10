package com.workat.tech.practice.string.immutable;

public class ImmutableDemo {
    public static void main(String[] args) {
        Address address = new Address("New York", "5th Avenue");
        User user = new User(1, "John Doe", address);

        System.out.println("Before modification: " + user);

        // Try modifying original Address object
        address.setCity("Los Angeles");
        System.out.println("After modifying original Address: " + user);

        // Try modifying Address via getter
        user.getAddress().setStreet("Broadway");
        System.out.println("After modifying Address via getter: " + user);
    }
}
