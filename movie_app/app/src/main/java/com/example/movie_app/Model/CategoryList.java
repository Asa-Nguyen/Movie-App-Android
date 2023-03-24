package com.example.movie_app.Model;

import java.util.List;

public class CategoryList {
    private String nameCategory;
    private List<Movie2> categoryMovieList;

    public CategoryList(String nameCategory, List<Movie2> imageMovieList) {
        this.nameCategory = nameCategory;
        this.categoryMovieList = imageMovieList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Movie2> getCategoryMovieList() {
        return categoryMovieList;
    }

    public void setCategoryMovieList(List<Movie2> categoryMovieList) {
        this.categoryMovieList = categoryMovieList;
    }
}
