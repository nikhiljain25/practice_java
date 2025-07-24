package com.workat.tech.practice.oops;

class BaseService {
    public int data = 20;
    public void display(BaseService service) {
        System.out.println("In Base");
    }
}

class ChildService extends BaseService {
    public int data = 10;
    public void display(ChildService service) {
        System.out.println("In Child");
    }

    public void display(BaseService service) {
        System.out.println("In Side Child Only");
    }
}
public class InheritanceExample {
    public static void main(String[] args) {
        BaseService base = new ChildService();
        System.out.println("\nBase Output....."); // Output: 20
        System.out.println(base.data); // Accessing data from BaseService, not ChildService due to static binding
        base.display(new ChildService()); // Calls BaseService's display method due to static binding

        System.out.println("\nChild Output....."); // Output: 20
        ChildService child = new ChildService();
        System.out.println(child.data); // Accessing data from ChildService
        child.display(new BaseService()); // output: In Base due to static binding
    }
}
