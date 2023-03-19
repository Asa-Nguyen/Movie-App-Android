package com.example.movie_app;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Adapter.CastCrewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ImageView mTrailerMovie;
    private TextView mMovieName, mIn4, mCategory, mEpisode, mSynopsis;
    private ImageButton playVideo;
    private RecyclerView rcvCast;
    private CastCrewAdapter castCrewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initUi();
        setUpRecyclerView();

        Glide.with(mTrailerMovie).load(getIntent().getStringExtra("trailerImage")).into(mTrailerMovie);
        mMovieName.setText(getIntent().getStringExtra("name"));
        mIn4.setText(getIntent().getStringExtra("in4"));
        mCategory.setText(getIntent().getStringExtra("category"));
        mSynopsis.setText(getIntent().getStringExtra("synopsis"));
    }

    private void initUi(){
        mTrailerMovie = (ImageView) findViewById(R.id.detail_trailer_image);
        mMovieName = (TextView) findViewById(R.id.detail_movie_name);
        mIn4 = (TextView) findViewById(R.id.detail_genre);
        mSynopsis = (TextView) findViewById(R.id.detail_synopsis_about);
        rcvCast = (RecyclerView) findViewById(R.id.detail_cast_rcv);
        playVideo = (ImageButton) findViewById(R.id.detail_play_button);
        mCategory = (TextView) findViewById(R.id.detail_category);
    }

    void setUpRecyclerView(){
        List<CastCrew> castCrewList = new ArrayList<>();
        castCrewList.add(new CastCrew("https://flxt.tmsimg.com/assets/415275_v9_bb.jpg", "John C. Reilly"));
        castCrewList.add(new CastCrew("https://flxt.tmsimg.com/assets/415275_v9_bb.jpg", "John C. Reilly"));
        castCrewList.add(new CastCrew("https://flxt.tmsimg.com/assets/415275_v9_bb.jpg", "John C. Reilly"));
        castCrewList.add(new CastCrew("https://flxt.tmsimg.com/assets/415275_v9_bb.jpg", "John C. Reilly"));
        castCrewList.add(new CastCrew("https://flxt.tmsimg.com/assets/415275_v9_bb.jpg", "John C. Reilly"));

        castCrewAdapter = new CastCrewAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvCast.setLayoutManager(linearLayoutManager);
        castCrewAdapter.setData(castCrewList);
        rcvCast.setAdapter(castCrewAdapter);
    }
}
