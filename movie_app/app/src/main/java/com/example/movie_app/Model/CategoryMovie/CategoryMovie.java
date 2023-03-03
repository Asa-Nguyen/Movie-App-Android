package com.example.movie_app.Model.CategoryMovie;

import java.util.List;

import com.example.movie_app.Model.Movie.Movie;

public class CategoryMovie {
    private String nameCategory;
    private List<Movie> movieList;

    public CategoryMovie(String nameCategory, List<Movie> movieList) {
        this.nameCategory = nameCategory;
        this.movieList = movieList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
