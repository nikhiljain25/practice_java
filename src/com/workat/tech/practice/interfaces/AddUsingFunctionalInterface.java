package com.workat.tech.practice.interfaces;

public class AddUsingFunctionalInterface {
    public static void main(String[] args) {
        AddInterface addFunction = (a, b) -> a+b;
        System.out.println("Addition Result: " + addFunction.add(10, 20));
    }

    @FunctionalInterface
    interface AddInterface {
        int add(int a, int b);
    }
}
