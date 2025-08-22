package com.workat.tech.practice.stream;

import java.util.*;
import java.util.stream.Collectors;

class AccountHolder {
    String name;
    String expenseType; // rent, transport, medical, food, etc
    double expenseAmount;

    public AccountHolder(String name, String expenseType, double expenseAmount) {
        this.name = name;
        this.expenseType = expenseType;
        this.expenseAmount = expenseAmount;
    }
    public String getexpenseType() { return expenseType; }
    public double getexpenseAmount() { return expenseAmount; }
    public String getName() { return name; }
}

public class SecondMaxexpenseAmount {
    public static void main(String[] args) {
        List<AccountHolder> accountHolders = Arrays.asList(
                new AccountHolder("Alice", "rent", 70000),
                new AccountHolder("Bob", "rent", 80000),
                new AccountHolder("Charlie", "rent", 60000),
                new AccountHolder("David", "transport", 50000),
                new AccountHolder("Eve", "transport", 55000),
                new AccountHolder("Frank", "transport", 52000),
                new AccountHolder("Grace", "medical", 30000),
                new AccountHolder("Heidi", "medical", 35000),
                new AccountHolder("Ivan", "medical", 40000)
        );
        Map<String, Optional<Double>> secondHighestMap =
                accountHolders.stream()
                        .collect(Collectors.groupingBy(
                                AccountHolder::getexpenseType,
                                Collectors.collectingAndThen(
                                        Collectors.mapping(
                                                AccountHolder::getexpenseAmount, Collectors.toList()),
                                        list -> list.stream()
                                                .distinct()
                                                .sorted(Comparator.reverseOrder())
                                                .skip(1)
                                                .findFirst()
                                )
                        ));
        secondHighestMap.forEach(
                (type, secondHighest) ->
                System.out.println(type + " -> " +
                        (secondHighest.isPresent() ? secondHighest.get() : "No second Highest"))
        );
    }
}
