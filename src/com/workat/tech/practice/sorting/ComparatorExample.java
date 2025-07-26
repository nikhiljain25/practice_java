package com.workat.tech.practice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Star Wars", 1977, 8.7));
        movieList.add(new Movie("Return of the Jedi", 1983, 8.4));
        movieList.add(new Movie("Empire Strikes Back", 1980, 8.8));

        //Sort movies by rating using Comparator and display all movies
        Collections.sort(movieList, new CompareByRating());
        System.out.println("Movies sorted by rating:");
        for (Movie movie : movieList) {
            System.out.println(movie.getName() + " (" + movie.getYear() + ") - Rating: " + movie.getRating());
        }

        // Sort movies by year using Comparable and display all movies
        Collections.sort(movieList, new CompareByName());
        System.out.println("\nMovies sorted by name:");
        for (Movie movie : movieList) {
            System.out.println(movie.getName() + " (" + movie.getYear() + ") - Rating: " + movie.getRating());
        }
    }

}
