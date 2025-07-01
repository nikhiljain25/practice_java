package com.workat.tech.practice.collection;

import java.util.concurrent.ConcurrentHashMap;

/**


 # ConcurrentHashMap Demo

 This project demonstrates the internal behavior of Java's ConcurrentHashMap with multithreaded read/write access.

 ## How to Run

 Compile and run the main class:

 ```
 javac com/example/concurrentmap/ConcurrentHashMapDemo.java
 java com.example.concurrentmap.ConcurrentHashMapDemo
 ```

 ## Features

 - Concurrent read/write using multiple threads
 - Demonstrates lock-free reads and synchronized bin-level writes

 .
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Runnable writer = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put("key" + i, i);
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 1000; i++) {
                map.get("key" + i);
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(writer);
        Thread t4 = new Thread(reader);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Map size: " + map.size());
    }
}
