package com.example.movie_app;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Adapter.EpisodeAdapter;
import com.example.movie_app.Adapter.TrailerDetailAdapter;
import com.example.movie_app.Database.Database;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Adapter.CastCrewAdapter;
import com.example.movie_app.Model.CategoryList;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ImageView mTrailerMovie;
    private TextView mMovieName, mIn4, mCategory, mEpisode, mSynopsis;
    private ImageButton playVideo;
    private RecyclerView rcvCast, rcvEpisode, rcvTrailer;
    private CastCrewAdapter castCrewAdapter;
    private EpisodeAdapter episodeAdapter;
    private TrailerDetailAdapter trailerDetailAdapter;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initUi();
        setUpCastRecyclerView();
        setUpEpisodeRecyclerView();
        setUpTrailerRecyclerView();


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
        rcvEpisode = (RecyclerView) findViewById(R.id.detail_episode_rcv);
        rcvTrailer = (RecyclerView) findViewById(R.id.rcv_trailer);
    }

    void setUpTrailerRecyclerView(){
        trailerDetailAdapter = new TrailerDetailAdapter(this, db.getMovie2Db());
        rcvTrailer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvTrailer.setHasFixedSize(true);
        rcvTrailer.setAdapter(trailerDetailAdapter);
    }

    void setUpEpisodeRecyclerView(){
        episodeAdapter = new EpisodeAdapter(this, getEpisodes());
        rcvEpisode.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcvEpisode.setHasFixedSize(true);
        rcvEpisode.setAdapter(episodeAdapter);
    }

    void setUpCastRecyclerView(){
        List<CastCrew> castCrewList = new ArrayList<>();
        castCrewList.add(new CastCrew("https://genk.mediacdn.vn/2019/11/9/photo-1-1573268390484205763958.jpg", "Tomioka Giyuu"));
        castCrewList.add(new CastCrew("https://genk.mediacdn.vn/2019/11/9/photo-1-1573268390484205763958.jpg", "Tomioka Giyuu"));
        castCrewList.add(new CastCrew("https://genk.mediacdn.vn/2019/11/9/photo-1-1573268390484205763958.jpg", "Tomioka Giyuu"));
        castCrewList.add(new CastCrew("https://genk.mediacdn.vn/2019/11/9/photo-1-1573268390484205763958.jpg", "Tomioka Giyuu"));
        castCrewList.add(new CastCrew("https://genk.mediacdn.vn/2019/11/9/photo-1-1573268390484205763958.jpg", "Tomioka Giyuu"));

        castCrewAdapter = new CastCrewAdapter(this, castCrewList);
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
                "1",
                true));
        episodeList.add(new Episode(
                "Chainsaw man",
                "https://static.wikia.nocookie.net/chainsaw-man/images/0/07/Episode_2-1.png/revision/latest?cb=20221018090613",
                "E2 - ARRIVAL IN TOKYO",
                "1",
                false));
        episodeList.add(new Episode(
                "Chainsaw man",
                "https://www.slashfilm.com/img/gallery/chainsaw-man-episode-3-is-an-action-packed-funny-and-gnarly/intro-1666735069.jpg",
                "E3 -  MEOWY'S WHEREABOUTS",
                "1",
                true));
        return episodeList;
    }

    private List<Movie> getMovie() {
        List<CastCrew> crewList = new ArrayList<>();
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/c2/Tobey_Maguire_2014.jpg&f=w", "Tobey Maguire"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/1/14/Willem_Dafoe_Cannes_2019.jpg&f=w", "Willem Dafoe"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/cf/James_Franco_4,_2013.jpg&f=w", "James Franco"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/e/e5/Joe_Manganiello_July_2015.jpg&f=w", "Joe Manganiello"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/d/d4/Rosemary_Harris_Spiderman_2007_Shankbone.jpg&f=w", "Rosemary Harris"));
        List<Movie> imageMovieList = new ArrayList<>();
        imageMovieList.add(new Movie(
                "https://znews-photo.zingcdn.me/w660/Uploaded/fsmhv/2014_02_05/Capt2_Teaser2_1Sht_v9_2.jpg",
                "Chainsaw man",
                "https://img3.hulu.com/user/v3/artwork/7b71b5a4-560b-4d8b-98c4-c5dee6004c21?base_image_bucket_name=image_manager&base_image=204c7e0e-a0bd-45fc-a7ff-5b6a60c90d62&size=1200x630&format=jpeg",
                "action comedy demons seinen",
                "2023 | 18+ | Season 1",
                crewList,
                getEpisodes(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." ));
        imageMovieList.add(new Movie(
                "https://m.media-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_.jpg",
                "Frozen",
                "https://www.broadcastprome.com/wp-content/uploads/2020/07/Frozen-1.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                getEpisodes(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://lumiere-a.akamaihd.net/v1/images/p_onward_19732_09862641.jpeg",
                "Onward",
                "https://www.showcasecinemas.com/Media/3032/onwardmobcall.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                getEpisodes(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://static.tvtropes.org/pmwiki/pub/images/ralphbreakstheinternet.png",
                "Ralph Breaks the Internet",
                "https://images2.alphacoders.com/953/thumb-1920-953261.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                getEpisodes(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://static.wikia.nocookie.net/netflix/images/2/27/Sponge_on_the_Run_Poster.jpg",
                "SpongeBob SquarePants",
                "https://lrmonline.com/wp-content/uploads/2021/03/SpongeBobSpongeOnTheRun-3840x2160-1-scaled.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                getEpisodes(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));

        return imageMovieList;
    }
}
