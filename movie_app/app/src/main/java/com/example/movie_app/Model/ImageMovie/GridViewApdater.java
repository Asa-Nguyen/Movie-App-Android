package com.example.movie_app.Model.ImageMovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.movie_app.R;

import java.util.List;


public class GridViewApdater extends BaseAdapter {

    private List<Movie> movieList;
    private LayoutInflater inflater;
    private Context context;

    public GridViewApdater(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        view = inflater.inflate(R.layout.item_search_movie, null);
        imageView = (ImageView) view.findViewById(R.id.image_movie);
        view.setTag(imageView);

        Movie movie = movieList.get(i);
        Glide.with(imageView).load(movie.getResourceId()).into(imageView);
        return view;
    }

}
