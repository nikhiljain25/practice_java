package com.workat.tech.practice.sorting;

import java.util.Comparator;

public class CompareByRating implements Comparator<Movie>{
    /**
     * This class implements Comparator to sort movies by their rating.
     * It overrides the compare method to compare two Movie objects based on their ratings.
     */
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return Double.compare(movie1.getRating(), movie2.getRating());
    }
}
