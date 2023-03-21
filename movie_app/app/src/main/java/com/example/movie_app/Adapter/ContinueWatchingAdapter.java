package com.example.movie_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.DetailActivity;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.R;

import java.util.List;

public class ContinueWatchingAdapter extends RecyclerView.Adapter<ContinueWatchingAdapter.ContinueWatchingViewHolder>{
    
    private Context context;
    private List<Movie> continueWatchingLists;

    public ContinueWatchingAdapter(Context context, List<Movie> continueWatchingLists) {
        this.context = context;
        this.continueWatchingLists = continueWatchingLists;
    }

    @NonNull
    @Override
    public ContinueWatchingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continue_watching,parent,false);
        return new ContinueWatchingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinueWatchingViewHolder holder, int position) {
        final Movie movie = continueWatchingLists.get(position);
        if(movie == null) return;
        // Load image url
        Glide.with(holder.imageMovie).load(movie.getFtrailer()).into(holder.imageMovie);
        holder.titleMovie.setText(movie.getFname());
        holder.genreMovie.setText(movie.getIn4());
        holder.imageMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("trailerImage", movie.getFtrailer());
                intent.putExtra("resourceId", movie.getFthumb());
                intent.putExtra("name", movie.getFname());
                intent.putExtra("in4", movie.getIn4());
                intent.putExtra("category", movie.getCategory());
                intent.putExtra("synopsis", movie.getSynopsis());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return continueWatchingLists != null ? continueWatchingLists.size() : 0;
    }

    public class ContinueWatchingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageMovie;
        TextView titleMovie, genreMovie, timeMovie;
        public ContinueWatchingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMovie = itemView.findViewById(R.id.continue_image_movie);
            timeMovie = itemView.findViewById(R.id.continue_in4);
            titleMovie = itemView.findViewById(R.id.continue_movie_name);
            genreMovie = itemView.findViewById(R.id.continue_in4);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
