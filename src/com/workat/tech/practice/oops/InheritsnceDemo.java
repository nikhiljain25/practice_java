package com.workat.tech.practice.oops;

class ParentClass {
    public void m1() {
        System.out.println("Parent class m1 method");
    }

    public void m2() {
        System.out.println("Parent class m2 method");
    }
}

class SubClass extends ParentClass {
    //@Override
    public void m1() {
        System.out.println("Child class m1 method");
    }

    public void m2() {
        System.out.println("Child class m2 method");
    }
}

public class InheritsnceDemo {
    public static void main(String[] args) {
//        ParentClass parent = new ParentClass();
//        parent.m1();
//        parent.m2();

//        SubClass child = new SubClass();
//        child.m1();
//        child.m2();

        ParentClass parentRefToChild = new SubClass();
        parentRefToChild.m1();
        parentRefToChild.m2();



    }
}
