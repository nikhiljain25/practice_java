package com.workat.tech.practice.string.immutable;

import java.util.HashMap;
import java.util.Map;

final class ImmutableStringDemo {

    // Make fields final to ensure immutability
    private final String name;
    private final int age;
    private final Map<String, String> metadata;

    public ImmutableStringDemo(String name, int age, Map<String, String> metadata) {
        this.name = name;
        this.age = age;
        // Use Map.copyOf to create an immutable copy of the metadata map
        Map<String, String> tempMap = new HashMap<>();
        for(Map.Entry<String, String> entry : metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap; // Use copyOf to ensure immutability
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Map<String, String> getMetadata() {
        // Return a copy of the metadata to ensure immutability
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}