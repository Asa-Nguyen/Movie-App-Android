package com.example.movie_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
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

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavViewHolder> {
    private Context context;
    private List<Movie> favoriteList = new ArrayList<>();

    public FavoriteAdapter(Context context, List<Movie> favoriteList) {
        this.context = context;
        this.favoriteList = favoriteList;
    }

    public void addData(Movie movie){
        favoriteList.add(movie);
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_movie, parent,false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        Movie movie = favoriteList.get(position);
        Glide.with(holder.imageView).load(movie.getFtrailer()).into(holder.imageView);
        holder.nameMovie.setText(movie.getFname());
        holder.genreMovie.setText(movie.getFfavorite());

        if (position == favoriteList.size() - 1) {
            // Set the bottom margin for the item view
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
            layoutParams.bottomMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 100, holder.itemView.getResources().getDisplayMetrics());
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Fuid", movie.getFuid());
                intent.putExtra("Fname", movie.getFname());
                intent.putExtra("Ftrailer", movie.getFtrailer());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteList != null ? favoriteList.size() : 0;
    }

    public class FavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView nameMovie, genreMovie;
        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_search);
            nameMovie = itemView.findViewById(R.id.item_search_name_movie);
            genreMovie = itemView.findViewById(R.id.item_search_genre);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
