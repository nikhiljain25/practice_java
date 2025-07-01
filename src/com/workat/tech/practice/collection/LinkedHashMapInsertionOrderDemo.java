
package com.workat.tech.practice.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 # LinkedHashMap Demo
 This project demonstrates the internal working of LinkedHashMap in Java through:
 - Access Order Example

 ## How to Run
 ```bash
 mvn compile
 mvn exec:java -Dexec.mainClass="com.example.linkedhashmap.LinkedHashMapAccessOrderDemo"
 */
public class LinkedHashMapInsertionOrderDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Apple");
        map.put(3, "Banana");
        map.put(2, "Cherry");

        System.out.println("Insertion order:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
