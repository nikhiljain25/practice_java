package com.workat.tech.practice.sorting;

import java.util.Comparator;

public class CompareByName implements Comparator<Movie> {
    /**
     * This class implements Comparator to sort movies by their name.
     * It overrides the compare method to compare two Movie objects based on their names.
     */
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getName().compareTo(movie2.getName());
    }
}
