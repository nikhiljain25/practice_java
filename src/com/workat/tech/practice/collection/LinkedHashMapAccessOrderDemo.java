
package com.workat.tech.practice.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 # LinkedHashMap Demo
 This project demonstrates the internal working of LinkedHashMap in Java through:
 - Insertion Order Example

 ## How to Run
 ```bash
 mvn compile
 mvn exec:java -Dexec.mainClass="com.example.linkedhashmap.LinkedHashMapInsertionOrderDemo"
 */
public class LinkedHashMapAccessOrderDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);

        map.put(1, "Apple");
        map.put(3, "Banana");
        map.put(2, "Cherry");

        map.get(1);
        map.get(2);

        System.out.println("Access order:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
