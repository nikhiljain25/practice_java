package com.workat.tech.practice.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

public class FindElementFromMap {



    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Bank1", "HSBC") ;
        map.put("Bank2", "SBI") ;
        map.put("Bank3", "ICICI") ;
        map.put("Bank4", "HDFC") ;

        // Find HSBC Bank name from the map using java 7 and Java 8 style
        System.out.println("\nFinding HSBC Bank using Java 7 style...");
        findBankNameUsingJava7(map, "HSBC");
        System.out.println("\nFinding HSBC Bank using Java 8 style...");
        findBankNameUsingJava8(map, "HSBC");
    }

    private static void findBankNameUsingJava7(HashMap<String, String> map, String hsbc) {
        // Find only Key from the map
        System.out.println("\nFind only Key from the map");
        findMapElement(map, hsbc);
        // Find key and value using Map.Entry Set
        System.out.println("\nFind key and value using Map.Entry Set");
        findMethodUsingMapEntrySet(map);
    }

    private static void findMapElement(HashMap<String, String> map, String hsbc) {
        for (String key : map.keySet()) {
            if (map.get(key).equals(hsbc)) {
                System.out.println("Found: " + key + " => " + map.get(key));
            }
        }
    }

    private static void findMethodUsingMapEntrySet(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("HSBC".equals(entry.getValue())) {
                System.out.println("Found: " + entry.getKey() + " => " + entry.getValue());
            }
        }
    }

    private static String findBankNameUsingJava8(HashMap<String, String> map, String hsbc) {
        Optional<String> bankName = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(hsbc))
                .map(entry-> entry.getKey() + " => " + entry.getValue())
                .findFirst();
        bankName.ifPresentOrElse(
                name -> System.out.println("Found: " + name),
                () -> System.out.println("Bank not found")
        );
        return bankName.orElse("Bank not found");
    }

}
