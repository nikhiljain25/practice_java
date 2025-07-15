package com.workat.tech.practice.oops;

public class CallByValueDemo {
    public static void changeValue(int x) {
        x = 100;
    }

    public static void main(String[] args) {
        int a = 10;
        changeValue(a);
        System.out.println(a);  // ➤ Output: 10
    }
}
