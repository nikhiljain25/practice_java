package com.workat.tech.practice.string.immutable;

import java.util.HashMap;
import java.util.Map;

public class StringImmutableResult {
    public static void main(String[] args) {

        // create a map and adding data
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        // create an immutable Student object
        ImmutableStringDemo s = new ImmutableStringDemo("GFG", 101, map);

        // accessing data
        System.out.println(s.getName());
        System.out.println(s.getAge());
        // accessing metadata
        System.out.println(s.getMetadata());

        // try to modify the original object
        // s.name = "NewName"; // This line would cause a compilation error due to final field
        // s.age = 102; // This line would cause a compilation error due to final field

        // try to modify the metadata map directly (should not affect original)
        s.getMetadata().put("3", "third");
        System.out.println(s.getMetadata());

        // try to modify the original map
        map.put("3", "third");
        System.out.println(s.getMetadata());

        // try to modify the map returned by getMetadata()
        s.getMetadata().put("4", "fourth");
        System.out.println(s.getMetadata());
    }
}
