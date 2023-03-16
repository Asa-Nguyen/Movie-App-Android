package com.example.movie_app.Model;

import java.util.List;

public class Movie {
    private String thumbUrl;
    private String nameMovie;
    private String trailerImage;
    private String category;
    private String in4;
    private List<CastCrew> castLists;
    private String synopsis;

    public Movie(String resourceId, String title) {
        this.thumbUrl = resourceId;
        this.nameMovie = title;
    }

    public Movie(){

    }
    public Movie(String thumbUrl, String title, String trailerImage, String category, String in4, List<CastCrew> castLists, String synopsis) {
        this.thumbUrl = thumbUrl;
        this.nameMovie = title;
        this.trailerImage = trailerImage;
        this.category = category;
        this.in4 = in4;
        this.castLists = castLists;
        this.synopsis = synopsis;
    }

    public List<CastCrew> getCastLists() {
        return castLists;
    }

    public void setCastLists(List<CastCrew> castLists) {
        this.castLists = castLists;
    }

    public String getTrailerImage() {return trailerImage;}

    public void setTrailerImage(String trailerImage) {this.trailerImage = trailerImage;}

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

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getNameMovie() {return nameMovie;}

    public void setNameMovie(String title) {
        this.nameMovie = title;
    }
}
