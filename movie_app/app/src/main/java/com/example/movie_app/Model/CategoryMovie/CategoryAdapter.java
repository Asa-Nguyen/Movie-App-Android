package com.example.movie_app.Model.CategoryMovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

import java.util.List;

import com.example.movie_app.Model.ImageMovie.ImageMovieAdapter;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context mContext;
    private List<CategoryMovie> mListMovie;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<CategoryMovie> list){
        this.mListMovie = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryMovie categoryMovie = mListMovie.get(position);
        if(categoryMovie == null){
            return;
        }
        holder.tvNameCategory.setText(categoryMovie.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvMovie.setLayoutManager(linearLayoutManager);

        ImageMovieAdapter bookAdapter = new ImageMovieAdapter();
        bookAdapter.setData(categoryMovie.getMovieList());
        holder.rcvMovie.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListMovie != null){
            return mListMovie.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory;
        private RecyclerView rcvMovie;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory = itemView.findViewById(R.id.tv_title_movie);
            rcvMovie = itemView.findViewById(R.id.rcv_movie);
        }
    }
}
