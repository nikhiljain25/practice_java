package com.workat.tech.practice.collection;

import java.util.List;

public class PrimeNumberDemo {
    List<Integer> list = List.of(1, 2, 3,4,5,6,7,8,9,10);
    public static void main(String[] args) {
        PrimeNumberDemo demo = new PrimeNumberDemo();
        demo.list.stream()
                .filter(PrimeNumberDemo::isPrime)
                .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
