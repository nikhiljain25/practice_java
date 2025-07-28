package com.workat.tech.practice.string;

public class StringAppendDemo {
    public static void main(String[] args) {
        int number = 15;
        StringBuilder result = new StringBuilder();
        if(number/3 ==5) {
//            System.out.println("tik");
            result.append("tik");
        }
        if(number/5 ==3) {
//            System.out.println("tak");
            result.append("tak");
        }
            System.out.println(result);
    }
}
