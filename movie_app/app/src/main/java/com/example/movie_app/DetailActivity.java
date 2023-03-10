package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView mTrailerMovie, mThumb;
    TextView mMovieName, mIn4, mCategory, mEpisode, mSynopsis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        mTrailerMovie = (ImageView) findViewById(R.id.trailer_image);
        mThumb = (ImageView) findViewById(R.id.thumb);
        mMovieName = (TextView) findViewById(R.id.movie_name);
//        mIn4 = (TextView) findViewById(R.id.in4);
//        mCategory = (TextView) findViewById(R.id.rcv_category);
//        mEpisode = (TextView) findViewById(R.id.rcv_episode);
        mSynopsis = (TextView) findViewById(R.id.synopsis_detail);

        mTrailerMovie.setImageResource(getIntent().getIntExtra("trailerImage", 0));
        mThumb.setImageResource(getIntent().getIntExtra("thumb", 0));
        mMovieName.setText(getIntent().getStringExtra("name"));
//        mIn4.setText(getIntent().getStringExtra("in4"));
//        mCategory.setText(getIntent().getStringExtra("category"));
        mSynopsis.setText(getIntent().getStringExtra("synopsis"));

    }

}
