package com.workat.tech.practice.oops;

public class OverridingDemo {
    public static void main(String[] args) {

        System.out.println("\n----------Parent class reference to Child object----------");
        //Parent reference to Child object
        Parent parentRef = new Childs();
        parentRef.m2(); // Calls Child's overloaded m2() method
        parentRef.m1(); // Calls Parent's m1() method due to static binding
        Childs.m1(); // Calls Child's overridden m1() method
        Parent.m1(); // Calls Parent's m1() method due to static binding

        System.out.println("\n-------------Parent Class Methods----------------");
        // Note: Parent's m2() cannot be called because it is not static
        Parent parent = new Parent();
        parent.m1(); // Calls Parent's m1() method
        parent.m2(); // Calls Parent's m2() method
        Parent.m1();
        //Parent.m2(); // It give compile time error because m2() is not static in Parent class

        System.out.println("\n-------------Child Class Methods----------------");
        // Childs reference to Child object
        Childs childs = new Childs();
        childs.m1(); // Calls Child's overridden m1() method
        childs.m2(); // Calls Child's overloaded m2() method
    }
}
