package com.example.movie_app.Model;

import java.util.List;

// Data in firebase
public class Movie2 {
    private String thumbUrl;
    private String trailerImageUrl;
    private String movieName;
    private String synopsis;
    private String videoTrailerUrl;
    private List<CastCrew> crewList;
    private List<String> categoryList;
    private List<String> episodeUrl;
    private List<String> in4;

    public Movie2() {
    }

    public Movie2(String thumbUrl, String trailerImageUrl, String movieName, String synopsis,
                  String videoTrailerUrl, List<CastCrew> crewList, List<String> categoryList,
                  List<String> episodeUrl, List<String> in4) {
        this.thumbUrl = thumbUrl;
        this.trailerImageUrl = trailerImageUrl;
        this.movieName = movieName;
        this.synopsis = synopsis;
        this.videoTrailerUrl = videoTrailerUrl;
        this.crewList = crewList;
        this.categoryList = categoryList;
        this.episodeUrl = episodeUrl;
        this.in4 = in4;
    }

    // GETTER AND SETTER

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getTrailerImageUrl() {
        return trailerImageUrl;
    }

    public void setTrailerImageUrl(String trailerImageUrl) {
        this.trailerImageUrl = trailerImageUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getVideoTrailerUrl() {
        return videoTrailerUrl;
    }

    public void setVideoTrailerUrl(String videoTrailerUrl) {
        this.videoTrailerUrl = videoTrailerUrl;
    }

    public List<CastCrew> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<CastCrew> crewList) {
        this.crewList = crewList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getEpisodeUrl() {
        return episodeUrl;
    }

    public void setEpisodeUrl(List<String> episodeUrl) {
        this.episodeUrl = episodeUrl;
    }

    public List<String> getIn4() {
        return in4;
    }

    public void setIn4(List<String> in4) {
        this.in4 = in4;
    }
}
