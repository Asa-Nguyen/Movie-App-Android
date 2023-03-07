package com.example.movie_app.Model.ImageMovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

import java.util.List;

public class ImageMovieAdapter extends RecyclerView.Adapter<ImageMovieAdapter.PosterViewHolder> {

    private List<ImageMovie> mImageMovie;

    public void setData(List<ImageMovie> list){
        this.mImageMovie = list;
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
        ImageMovie imageMovie = mImageMovie.get(position);
        if(imageMovie == null) return;
        holder.imagePoster.setImageResource(imageMovie.getResourceId());
    }

    @Override
    public int getItemCount() {
        if(mImageMovie != null){
            return mImageMovie.size();
        }
        return 0;
    }

    public class PosterViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePoster;
        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.image_movie);
        }
    }
}
