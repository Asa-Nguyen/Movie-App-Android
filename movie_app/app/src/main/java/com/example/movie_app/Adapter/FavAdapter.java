package com.example.movie_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.DetailActivity;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.Model.Movie2;
import com.example.movie_app.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    private Context context;
    private List<Movie2> movieList;

    public FavAdapter(Context context, List<Movie2> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavViewHolder(LayoutInflater.from(context).inflate(R.layout.item_favourite, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        final Movie2 imageMovie = movieList.get(position);
        Glide.with(holder.favThumb).load(imageMovie.getFthumb()).into(holder.favThumb);
        holder.favNameMovie.setText(imageMovie.getFname());
        holder.favFavorite.setText(imageMovie.toStringIn4());
        holder.favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("trailerImage", imageMovie.getFtrailer());
                intent.putExtra("resourceId", imageMovie.getFthumb());
                intent.putExtra("name", imageMovie.getFname());
                intent.putExtra("in4", imageMovie.toStringIn4());
                intent.putExtra("category", imageMovie.toStringCategory());
                intent.putExtra("synopsis", imageMovie.getFsynopsis());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    public class FavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView favThumb;
        TextView favNameMovie;
        TextView favFavorite;
        Button favButton;
        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            favThumb = itemView.findViewById(R.id.fav_thumb);
            favNameMovie = itemView.findViewById(R.id.episode_name_movie);
            favFavorite = itemView.findViewById(R.id.fav_favorite);
            favButton = itemView.findViewById(R.id.fav_watching_btn);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
