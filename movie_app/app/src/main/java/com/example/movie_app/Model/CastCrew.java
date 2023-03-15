package com.example.movie_app.Model;

public class CastCrew {
    private String imageCastUrl;
    private String nameCast;

    public CastCrew(String imageUrl, String name) {
        this.imageCastUrl = imageUrl;
        this.nameCast = name;
    }

    public String getImageCastUrl() {
        return imageCastUrl;
    }

    public void setImageCastUrl(String imageCastUrl) {
        this.imageCastUrl = imageCastUrl;
    }

    public String getNameCast() {
        return nameCast;
    }

    public void setNameCast(String nameCast) {
        this.nameCast = nameCast;
    }
}
