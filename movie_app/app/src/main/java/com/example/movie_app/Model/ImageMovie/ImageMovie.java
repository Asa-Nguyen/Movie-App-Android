package com.example.movie_app.Model.ImageMovie;

import java.util.List;

public class ImageMovie {
    private int resourceId;
    private String title;
    private double starRating;
    private String[] listCategory = {"Action", "Adventure", "Comedy"};
    private String time;
    private String synopsis;

    public ImageMovie(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
    }

    public ImageMovie(int resourceId, String title, double starRating, String[] listCategory, String time, String synopsis) {
        this.resourceId = resourceId;
        this.title = title;
        this.starRating = starRating;
        this.listCategory = listCategory;
        this.time = time;
        this.synopsis = synopsis;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    public String[] getListCategory() {
        return listCategory;
    }

    public void setListCategory(String[] listCategory) {
        this.listCategory = listCategory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
