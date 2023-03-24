package com.example.movie_app.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

// Data in firebase
@IgnoreExtraProperties
public class Movie2 {
    private String Fuid;
    private String Fthumb;
    private String Ftrailer;
    private String Fname;
    private String Fsynopsis;
    private String FvideoTrailer;
    private int Fmmpa;
    private int Fyear;
    private int Fseason;
    private List<Episode> Eepisode;
    private List<CastCrew> Ccast;
    private List<CategoryMovie> Ccategory;

    public Movie2() {
    }

    public Movie2(String fuid, String fthumb, String ftrailer, String fname, String fsynopsis, String fvideoTrailer, int fmmpa, int fyear, int fseason) {
        Fuid = fuid;
        Fthumb = fthumb;
        Ftrailer = ftrailer;
        Fname = fname;
        Fsynopsis = fsynopsis;
        FvideoTrailer = fvideoTrailer;
        Fmmpa = fmmpa;
        Fyear = fyear;
        Fseason = fseason;
    }

    public Movie2(String fuid, String fthumb, String ftrailer, String fname, String fsynopsis, String fvideoTrailer, int fmmpa, int fyear, int fseason, List<Episode> eepisode, List<CastCrew> ccast, List<CategoryMovie> ccategory) {
        Fuid = fuid;
        Fthumb = fthumb;
        Ftrailer = ftrailer;
        Fname = fname;
        Fsynopsis = fsynopsis;
        FvideoTrailer = fvideoTrailer;
        Fmmpa = fmmpa;
        Fyear = fyear;
        Fseason = fseason;
        Eepisode = eepisode;
        Ccast = ccast;
        Ccategory = ccategory;
    }

    public String toStringIn4(){
        return getFyear() + " " + getFmmpa() + " " + getFseason();
    }

    public String toStringCategory(){
        String res = "";
        for(CategoryMovie category: getCcategory()){
            res+=category.getNameCategory()+" ";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Movie2{" +
                "Fuid='" + Fuid + '\'' +
                ", Fthumb='" + Fthumb + '\'' +
                ", Ftrailer='" + Ftrailer + '\'' +
                ", Fname='" + Fname + '\'' +
                ", Fsynopsis='" + Fsynopsis + '\'' +
                ", FvideoTrailer='" + FvideoTrailer + '\'' +
                ", Fmmpa=" + Fmmpa +
                ", Fyear=" + Fyear +
                ", Fseason=" + Fseason +
                '}';
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
        Eepisode = eepisode;
    }

    public List<CastCrew> getCcast() {
        return Ccast;
    }

    public void setCcast(List<CastCrew> ccast) {
        Ccast = ccast;
    }

    public List<CategoryMovie> getCcategory() {
        return Ccategory;
    }

    public void setCcategory(List<CategoryMovie> ccategory) {
        Ccategory = ccategory;
    }

    public int getFseason() {
        return Fseason;
    }

    public void setFseason(int fseason) {
        Fseason = fseason;
    }
}
