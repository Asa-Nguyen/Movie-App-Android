package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.CastCrew.CastCrew;
import com.example.movie_app.Model.CastCrew.CastCrewAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    ImageView mTrailerMovie, mThumb;
    TextView mMovieName, mIn4, mCategory, mEpisode, mSynopsis;
    ImageButton playVideo;
    // rcv cast
    private RecyclerView rcvCast;
    private CastCrewAdapter castCrewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        mTrailerMovie = (ImageView) findViewById(R.id.trailer_image);
        mThumb = (ImageView) findViewById(R.id.thumb);
        mMovieName = (TextView) findViewById(R.id.movie_name);
        mIn4 = (TextView) findViewById(R.id.in4);
        mSynopsis = (TextView) findViewById(R.id.synopsis_detail);

        Glide.with(mThumb).load(getIntent().getStringExtra("resourceId")).into(mThumb);
        Glide.with(mTrailerMovie).load(getIntent().getStringExtra("trailerImage")).into(mTrailerMovie);
        mMovieName.setText(getIntent().getStringExtra("name"));
        mIn4.setText(getIntent().getStringExtra("in4"));
        mSynopsis.setText(getIntent().getStringExtra("synopsis"));

        // rcv cast and crew
        rcvCast = findViewById(R.id.rcv_cast_detail);
        setupRcvCast();

        // btn go to watching movie
        playVideo = (ImageButton) findViewById(R.id.play_video_btn);
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVideoPlayActivity();
            }
        });
    }

    void setupRcvCast(){
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

    public void onVideoPlayActivity(){
        Intent intent = new Intent(this, VideoPlayActivity.class);
        startActivity(intent);
    }

}
