package com.workat.tech.practice.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> {
            System.out.println("All threads have reached the barrier. Proceeding with the next step.");
        });

        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("Thread reached barrier.");
                try {
                    cyclicBarrier.await(); // Wait for other threads to reach the barrier
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread passed the barrier.");
            }).start();
        }
    }
}
