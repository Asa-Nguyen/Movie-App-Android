package com.example.movie_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.R;

import java.util.List;


public class GridViewApdater extends BaseAdapter {

    private List<Movie> gridViewLists;
    private LayoutInflater inflater;
    private Context context;

    public GridViewApdater(Context context, List<Movie> movieList) {
        this.gridViewLists = movieList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return gridViewLists != null ? gridViewLists.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return gridViewLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        view = inflater.inflate(R.layout.item_grid_movie, null);
        imageView = (ImageView) view.findViewById(R.id.image_grid);
        view.setTag(imageView);

        Movie movie = gridViewLists.get(i);
        // Load image url
        Glide.with(imageView).load(movie.getThumbUrl()).into(imageView);
        return view;
    }

}
