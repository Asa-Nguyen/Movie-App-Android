package com.example.movie_app.Model.CategoryMovie;

import java.util.List;

import com.example.movie_app.Model.ImageMovie.Movie;

public class CategoryMovie {
    private String nameCategory;
    private List<Movie> imageMovieList;

    public CategoryMovie(String nameCategory, List<Movie> imageMovieList) {
        this.nameCategory = nameCategory;
        this.imageMovieList = imageMovieList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Movie> getMovieList() {
        return imageMovieList;
    }

    public void setMovieList(List<Movie> imageMovieList) {
        this.imageMovieList = imageMovieList;
    }
}
