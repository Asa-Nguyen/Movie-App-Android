package com.example.movie_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.DetailActivity;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.R;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>{
    Context context;
    private List<Movie> listCollections;

    public CollectionAdapter(Context context, List<Movie> listCollections) {
        this.context = context;
        this.listCollections = listCollections;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        final Movie movie = listCollections.get(position);
        Glide.with(holder.imageMovie).load(movie.getFtrailer()).into(holder.imageMovie);
        holder.imageMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Fuid", movie.getFuid());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCollections != null ? listCollections.size() : 0;
    }

    public class CollectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageMovie;
        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMovie = itemView.findViewById(R.id.image_collection);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
