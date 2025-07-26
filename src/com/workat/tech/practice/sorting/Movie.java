package com.workat.tech.practice.sorting;

class Movie implements Comparable<Movie> {
    private String name;
    private int year;
    private double rating;

    public Movie(String name, int year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.year - movie.getYear();
    }
}
