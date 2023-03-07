package com.example.movie_app.Model.CategoryMovie;

import java.util.List;

import com.example.movie_app.Model.ImageMovie.ImageMovie;

public class CategoryMovie {
    private String nameCategory;
    private List<ImageMovie> imageMovieList;

    public CategoryMovie(String nameCategory, List<ImageMovie> imageMovieList) {
        this.nameCategory = nameCategory;
        this.imageMovieList = imageMovieList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<ImageMovie> getMovieList() {
        return imageMovieList;
    }

    public void setMovieList(List<ImageMovie> imageMovieList) {
        this.imageMovieList = imageMovieList;
    }
}
