package com.example.movie_app.Model.ImageMovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.DetailActivity;
import com.example.movie_app.HomeFullActivity;
import com.example.movie_app.R;

import java.util.List;

public class ImageMovieAdapter extends  RecyclerView.Adapter<ImageMovieAdapter.ImageMovieViewHolder>{
    Context context;
    List<ImageMovie> imageMovies;

    public void setData(List<ImageMovie> list){
        this.imageMovies = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ImageMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageMovieViewHolder holder, int position) {
        final ImageMovie imageMovie = imageMovies.get(position);
        if(imageMovie == null) return;
        Glide.with(holder.imageView).load(imageMovies.get(position).getResourceId()).into(holder.imageView);
//        holder.imageView.setImageResource(imageMovie.getResourceId());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("trailerImage", imageMovie.getTrailerImage());
                intent.putExtra("resourceId", imageMovie.getResourceId());
                intent.putExtra("name", imageMovie.getNameMovie());
                intent.putExtra("in4", imageMovie.getIn4());
                intent.putExtra("category", imageMovie.getCategory());
                intent.putExtra("synopsis", imageMovie.getSynopsis());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(imageMovies != null){
            return imageMovies.size();
        }
        return 0;
    }

    public class ImageMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        public ImageMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_movie);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
