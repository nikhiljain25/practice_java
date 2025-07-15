package com.workat.tech.practice.oops;

class Parent {
   public static void m1() {
        System.out.println("Parent's m1()");
    }

    void m2() {
        System.out.println("Parent's m2()");
    }
}

class Childs extends Parent {

    public static void m1() {
        System.out.println("Child's overridden m1()");
    }

    @Override
    void m2() { // Overloading, not overriding
        System.out.println("Child's overloaded m2() " );
    }
}
