package Poster;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app__team.R;

public class BookAdapter {
    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePoster;
        private TextView tvTitle;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.img_book);
        }
    }
}
