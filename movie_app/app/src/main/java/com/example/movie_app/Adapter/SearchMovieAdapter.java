package com.example.movie_app.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

import android.content.Context;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieAdapter.SearchMovieViewHolder> implements Filterable {
    Context context;
    List<Movie> searchMovieList;

    public SearchMovieAdapter(Context context, List<Movie> searchMovieList) {
        this.context = context;
        this.searchMovieList = searchMovieList;
    }

    @NonNull
    @Override
    public SearchMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_movie, parent,false);
        return new SearchMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMovieViewHolder holder, int position) {
        Movie movie = searchMovieList.get(position);
        Glide.with(holder.imageView).load(movie.getThumbUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return searchMovieList != null ? searchMovieList.size() : 0;
    }

    public class SearchMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        public SearchMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_search);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                List<Movie> searchResult = new ArrayList<>();
                for(Movie movie : searchMovieList){
                    if(movie.getNameMovie().toLowerCase().contains(strSearch.toLowerCase())){
                        searchResult.add(movie);
                    }
                }
                searchMovieList = searchResult;
                FilterResults filterResults = new FilterResults();
                filterResults.values = searchMovieList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchMovieList = (List<Movie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}

