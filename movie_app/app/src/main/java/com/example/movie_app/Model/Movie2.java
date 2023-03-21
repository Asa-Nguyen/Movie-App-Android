package com.example.movie_app.Model;

import java.util.List;

// Data in firebase
public class Movie2 {
    private String Fuid;
    private String Fthumb;
    private String Ftrailer;
    private String Fname;
    private String Fsynopsis;
    private String FvideoTrailer;
    private int Fmmpa;
    private int Fyear;
    private List<Episode> Eepisode;
    private List<CastCrew> Ccast;
    private List<CategoryMovie> Ccategory;

    public Movie2() {
    }

    public Movie2(String Fuid, String fthumb, String ftrailer, String fname, String fsynopsis, String fvideoTrailer, int fmmpa, int fyear, List<Episode> Eepisode, List<CastCrew> Ccast, List<CategoryMovie> Ccategory) {
        this.Fuid = Fuid;
        this.Fthumb = fthumb;
        this.Ftrailer = ftrailer;
        this.Fname = fname;
        this.Fsynopsis = fsynopsis;
        this.FvideoTrailer = fvideoTrailer;
        this.Fmmpa = fmmpa;
        this.Fyear = fyear;
        this.Eepisode = Eepisode;
        this.Ccast = Ccast;
        this.Ccategory = Ccategory;
    }

    public String getFuid() {
        return Fuid;
    }

    public void setFuid(String fuid) {
        Fuid = fuid;
    }

    public String getFthumb() {
        return Fthumb;
    }

    public void setFthumb(String fthumb) {
        Fthumb = fthumb;
    }

    public String getFtrailer() {
        return Ftrailer;
    }

    public void setFtrailer(String ftrailer) {
        Ftrailer = ftrailer;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFsynopsis() {
        return Fsynopsis;
    }

    public void setFsynopsis(String fsynopsis) {
        Fsynopsis = fsynopsis;
    }

    public String getFvideoTrailer() {
        return FvideoTrailer;
    }

    public void setFvideoTrailer(String fvideoTrailer) {
        FvideoTrailer = fvideoTrailer;
    }

    public int getFmmpa() {
        return Fmmpa;
    }

    public void setFmmpa(int fmmpa) {
        Fmmpa = fmmpa;
    }

    public int getFyear() {
        return Fyear;
    }

    public void setFyear(int fyear) {
        Fyear = fyear;
    }

    public List<Episode> getEepisode() {
        return Eepisode;
    }

    public void setEepisode(List<Episode> eepisode) {
        this.Eepisode = eepisode;
    }

    public List<CastCrew> getCcast() {
        return Ccast;
    }

    public void setCcast(List<CastCrew> ccast) {
        this.Ccast = ccast;
    }

    public List<CategoryMovie> getCcategory() {
        return Ccategory;
    }

    public void setCcategory(List<CategoryMovie> ccategory) {
        this.Ccategory = ccategory;
    }
}
