package com.workat.tech.practice.string;

public class StringOperations {
    public static void main(String[] args) {
        String s1 = "Java interview";
        String s2 = new String("Java interview");
        String s3 = s1;

        if(s1 == s2) {
            System.out.println("s1 == s2");
        }

        if(s1 == s3) {
            System.out.println("s1 == s3");
        }

        if(s1.equalsIgnoreCase(s3)) {
            System.out.println("\ns1 equalsIgnoreCase s3");
        }
    }
}
