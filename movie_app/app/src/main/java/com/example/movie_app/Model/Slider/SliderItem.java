package com.example.movie_app.Model.Slider;

public class SliderItem {
    private String imageUrl;

    public SliderItem(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImage(){
        return imageUrl;
    }

}
