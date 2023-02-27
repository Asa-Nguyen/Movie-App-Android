package Poster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testcode.R;

import java.util.List;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {

    private List<Poster> mPoster;

    public void setData(List<Poster> list){
        this.mPoster= list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster,parent,false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        Poster poster = mPoster.get(position);
        if(poster == null) return;
        holder.imagePoster.setImageResource(poster.getResourceId());
    }

    @Override
    public int getItemCount() {
        if(mPoster != null){
            return mPoster.size();
        }
        return 0;
    }

    public class PosterViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePoster;
        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.img_pos);
        }
    }
}
