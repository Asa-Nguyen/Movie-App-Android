package com.example.movie_app;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Adapter.EpisodeAdapter;
import com.example.movie_app.Adapter.TrailerDetailAdapter;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Adapter.CastCrewAdapter;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    private ImageView mTrailerMovie;
    private TextView mMovieName, mIn4, mCategory, mEpisode, mSynopsis;
    private ImageButton playVideo;
    private RecyclerView rcvCast, rcvEpisode, rcvTrailer;
    private CastCrewAdapter castCrewAdapter;
    private EpisodeAdapter episodeAdapter;
    private TrailerDetailAdapter trailerDetailAdapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        // main uid movie
        String FuidMovie = getIntent().getStringExtra("Fuid");
        initUi();

        DocumentReference movieRef = db.collection("movie").document(FuidMovie);
        movieRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Movie moviePage = documentSnapshot.toObject(Movie.class);
                Glide.with(mTrailerMovie).load(moviePage.getFtrailer()).into(mTrailerMovie);
                mMovieName.setText(moviePage.getFname());
                mSynopsis.setText(moviePage.getFsynopsis());
                mCategory.setText(moviePage.toStringCategory());
                mIn4.setText(moviePage.toStringIn4());
                mEpisode.setText(moviePage.toStringSeasonEpisode());

            }
        });

        DocumentReference episodeRef = db.collection("episode").document(FuidMovie);
        episodeRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        List<Episode> episodeList = new ArrayList<>();
                        ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) document.get(FuidMovie);
                        for(Map map : data){
                            Episode dataEpisode = new Episode(map.get("nameMovie").toString(),
                                    map.get("imageEpisode").toString(),
                                    map.get("episodeTitle").toString(),
                                    map.get("playMovie").toString());
                            episodeList.add(dataEpisode);
                        }
                        setUpEpisodeRecyclerView(episodeList);
                    }
                }
            }
        });

        DocumentReference castRef = db.collection("cast").document(FuidMovie);
        castRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        List<CastCrew> castCrewList = new ArrayList<>();
                        ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) document.get(FuidMovie);
                        for(Map map : data){
                            CastCrew castCrew = new CastCrew(map.get("imageUrl").toString(),
                                    map.get("nameCast").toString());
                            castCrewList.add(castCrew);
                        }
                        setUpCastRecyclerView(castCrewList);
                    }
                }
            }
        });
    }

    private void initUi(){
        mTrailerMovie = (ImageView) findViewById(R.id.detail_trailer_image);
        mMovieName = (TextView) findViewById(R.id.detail_movie_name);
        mIn4 = (TextView) findViewById(R.id.detail_genre);
        mSynopsis = (TextView) findViewById(R.id.detail_synopsis_about);
        rcvCast = (RecyclerView) findViewById(R.id.detail_cast_rcv);
        playVideo = (ImageButton) findViewById(R.id.detail_play_button);
        mCategory = (TextView) findViewById(R.id.detail_category);
        rcvEpisode = (RecyclerView) findViewById(R.id.detail_episode_rcv);
        rcvTrailer = (RecyclerView) findViewById(R.id.rcv_trailer);
        mEpisode = (TextView) findViewById(R.id.title_episode);
    }

    void setUpTrailerRecyclerView(List<Movie> movie2List){
        trailerDetailAdapter = new TrailerDetailAdapter(this, movie2List);
        rcvTrailer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvTrailer.setHasFixedSize(true);
        rcvTrailer.setAdapter(trailerDetailAdapter);
    }

    void setUpEpisodeRecyclerView(List<Episode> episodeList){
        episodeAdapter = new EpisodeAdapter(this, episodeList);
        rcvEpisode.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcvEpisode.setHasFixedSize(true);
        rcvEpisode.setAdapter(episodeAdapter);
    }

    void setUpCastRecyclerView(List<CastCrew> list){
                castCrewAdapter = new CastCrewAdapter(this, list);
        rcvCast.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvCast.setHasFixedSize(true);
        rcvCast.setAdapter(castCrewAdapter);
    }

    private List<Episode> getEpisodes(){
        List<Episode> episodeList = new ArrayList<>();
        episodeList.add(new Episode(
                "Chainsaw man",
                "https://www.crunchyroll.com/imgsrv/display/thumbnail/1200x675/catalog/crunchyroll/91c8f9e4ddbcbcee7d8c12ace10e6dcf.jpe",
                "E1 - DOG & CHAINSAW",
                "1"));
        episodeList.add(new Episode(
                "Chainsaw man",
                "https://static.wikia.nocookie.net/chainsaw-man/images/0/07/Episode_2-1.png/revision/latest?cb=20221018090613",
                "E2 - ARRIVAL IN TOKYO",
                "1"));
        episodeList.add(new Episode(
                "Chainsaw man",
                "https://www.slashfilm.com/img/gallery/chainsaw-man-episode-3-is-an-action-packed-funny-and-gnarly/intro-1666735069.jpg",
                "E3 -  MEOWY'S WHEREABOUTS",
                "1"));
        return episodeList;
    }
}
