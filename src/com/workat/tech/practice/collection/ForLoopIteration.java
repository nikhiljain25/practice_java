package com.workat.tech.practice.collection;

public class ForLoopIteration {
    public static void main(String []args) {
        int x = 0;
        for(int i=0; i<10000000; i++) {
             x = x+1;
            System.out.println(x);
        }
    }
}
