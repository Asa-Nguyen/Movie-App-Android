package com.example.movie_app.Model.ImageMovie;

import java.util.List;

public class ImageMovie {
    private int resourceId;
    private String title;
    private double starRating;
    private String[] listCategory = {"Action", "Adventure", "Comedy"};
    private String synopsis;

    public ImageMovie(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
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
}
