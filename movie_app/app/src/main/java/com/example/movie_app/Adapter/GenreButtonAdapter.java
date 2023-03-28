package com.example.movie_app.Adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.Model.CategoryList;
import com.example.movie_app.R;

import java.util.List;

public class GenreButtonAdapter extends RecyclerView.Adapter<GenreButtonAdapter.CategoryButtonViewHolder>{

    private Context mContext;
    private List<CategoryList> categoryButtonLists;

    public GenreButtonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<CategoryList> categoryButtonLists){
        this.categoryButtonLists = categoryButtonLists;
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
        CategoryList categoryBtn = categoryButtonLists.get(position);
        if(categoryBtn == null){
            return;
        }
        if(position == 0 || position == categoryButtonLists.size()){
        }
        holder.btnCategory.setText(categoryBtn.getNameCategory());

        if(position == getItemCount() - 1) {
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
            layoutParams.rightMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 25, holder.itemView.getResources().getDisplayMetrics());
        }
    }

    @Override
    public int getItemCount() {
        return categoryButtonLists != null ? categoryButtonLists.size() : 0;
    }

    public class CategoryButtonViewHolder extends RecyclerView.ViewHolder{

        private  TextView btnCategory;
        private CardView item_btn_categories;
        public CategoryButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCategory = (TextView) itemView.findViewById(R.id.buttonCategory);
            item_btn_categories = (CardView) itemView.findViewById(R.id.item_btn_category);
        }
    }
}
