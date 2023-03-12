package com.example.movie_app.Model.CategoryMovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

import java.util.List;

public class CategoryButtonAdapter extends RecyclerView.Adapter<CategoryButtonAdapter.CategoryButtonViewHolder>{

    private Context mContext;
    private List<CategoryMovie> mListMovie;

    public CategoryButtonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<CategoryMovie> list){
        this.mListMovie = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_btn_category, parent, false);
        return new CategoryButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryButtonViewHolder holder, int position) {
        CategoryMovie categoryMovie = mListMovie.get(position);
        if(categoryMovie == null){
            return;
        }
        holder.btnCategory.setText(categoryMovie.getNameCategory());
    }

    @Override
    public int getItemCount() {
        if(mListMovie != null){
            return mListMovie.size();
        }
        return 0;
    }

    public class CategoryButtonViewHolder extends RecyclerView.ViewHolder{

        private  TextView btnCategory;
        public CategoryButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCategory = (TextView) itemView.findViewById(R.id.buttonCategory);
        }
    }
}
