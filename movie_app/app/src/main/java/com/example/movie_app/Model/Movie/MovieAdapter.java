package com.example.movie_app.Model.Movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.PosterViewHolder> {

    private List<Movie> mMovie;

    public void setData(List<Movie> list){
        this.mMovie = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        Movie movie = mMovie.get(position);
        if(movie == null) return;
        holder.imagePoster.setImageResource(movie.getResourceId());
    }

    @Override
    public int getItemCount() {
        if(mMovie != null){
            return mMovie.size();
        }
        return 0;
    }

    public class PosterViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePoster;
        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id .image_movie);
        }
    }
}
