package com.workat.tech.practice.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("Thread finished work.");
                latch.countDown(); // Decrement the count of the latch
            }).start();
        }
        latch.await(); // Wait until the count reaches zero
        System.out.println("All threads completed. Proceeding...");
    }
}
