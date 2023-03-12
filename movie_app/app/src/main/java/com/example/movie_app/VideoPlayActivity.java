package com.example.movie_app;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.Model.CastCrew.CastCrew;
import com.example.movie_app.Model.CastCrew.CastCrewAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayActivity extends AppCompatActivity {
    private VideoView videoView;
//  Rcv cast
    private RecyclerView rcvCast;
    private CastCrewAdapter castCrewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        videoView = (VideoView) findViewById(R.id.video_play);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.demon_slayder;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // rcv cast
        rcvCast = findViewById(R.id.rcv_cast_video);
        setupRcvCast();
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

}
