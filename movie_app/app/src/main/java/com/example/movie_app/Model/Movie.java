package com.example.movie_app.Model;

import java.util.List;

public class Movie {
    private String Fthumb;
    private String Fname;
    private String Ftrailer;
    private String category;
    private String in4;
    private List<CastCrew> castLists;
    private List<Episode> episodeList;
    private String synopsis;

    public Movie(String resourceId, String title) {
        this.Fthumb = resourceId;
        this.Fname = title;
    }

    public Movie(){

    }

    public Movie(String Fthumb, String Fname, String Ftrailer, String category, String in4, List<CastCrew> castLists, List<Episode> episodeList, String synopsis) {
        this.Fthumb = Fthumb;
        this.Fname = Fname;
        this.Ftrailer = Ftrailer;
        this.category = category;
        this.in4 = in4;
        this.castLists = castLists;
        this.episodeList = episodeList;
        this.synopsis = synopsis;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public List<CastCrew> getCastLists() {
        return castLists;
    }

    public void setCastLists(List<CastCrew> castLists) {
        this.castLists = castLists;
    }

    public String getFtrailer() {return Ftrailer;}

    public void setFtrailer(String ftrailer) {this.Ftrailer = ftrailer;}

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

    public String getFthumb() {
        return Fthumb;
    }

    public void setFthumb(String fthumb) {
        this.Fthumb = fthumb;
    }

    public String getFname() {return Fname;}

    public void setFname(String title) {
        this.Fname = title;
    }
}
