package com.example.movie_app.Model.ImageMovie;

import android.widget.ImageView;

import java.util.List;

public class ImageMovie {
    private int resourceId;
    private String nameMovie;
    private int trailerImage;
    private int thumb;
    private String category;
    private String in4;
    private String synopsis;

    public ImageMovie(int resourceId, String title) {
        this.resourceId = resourceId;
        this.nameMovie = title;
    }


    public ImageMovie(int resourceId, String title, int trailerImage, int thumb, String category, String in4, String synopsis) {
        this.resourceId = resourceId;
        this.nameMovie = title;
        this.trailerImage = trailerImage;
        this.thumb = thumb;
        this.category = category;
        this.in4 = in4;
        this.synopsis = synopsis;
    }

    public int getTrailerImage() {return trailerImage;}

    public void setTrailerImage(int trailerImage) {this.trailerImage = trailerImage;}

    public int getThumb() {return thumb;}

    public void setThumb(int thumb) {this.thumb = thumb;}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIn4() {
        return in4;
    }

    public void setIn4(String in4) {
        this.in4 = in4;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameMovie() {return nameMovie;}

    public void setNameMovie(String title) {
        this.nameMovie = title;
    }
}
