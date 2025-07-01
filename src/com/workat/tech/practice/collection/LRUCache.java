
package com.workat.tech.practice.collection;

import java.util.LinkedHashMap;
import java.util.Map;
/**

 # LinkedHashMap Demo
 This project demonstrates the internal working of LinkedHashMap in Java through:
 - LRU Cache using LinkedHashMap

 ## How to Run

 ```bash
 mvn compile
 mvn exec:java -Dexec.mainClass="com.example.linkedhashmap.LRUCache"
 */

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1);
        cache.put(4, "D");

        System.out.println("LRU Cache content:");
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
