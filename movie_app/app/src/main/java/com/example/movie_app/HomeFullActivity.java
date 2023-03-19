package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import com.example.movie_app.Adapter.ContinueWatchingAdapter;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Adapter.CategoryAdapter;
import com.example.movie_app.Adapter.GenreButtonAdapter;
import com.example.movie_app.Model.CategoryMovie;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.Adapter.SliderAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFullActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    private RecyclerView rcvCategoryImage, rcvGenreButton, rcvWatchingContinue;
    private BottomNavigationView navigationView;
    // Adapter
    private CategoryAdapter categoryAdapter;
    private GenreButtonAdapter categoryButtonAdapter;
    private ContinueWatchingAdapter continueWatchingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefull);
        initUi();
        setImageSlider(viewPager2, sliderHandler);
        setWatchingContinueRecyclerView();
        setGenreButtonRecyclerView();
        setGenreMovieRecyclerView();

        navigationView.setSelectedItemId(R.id.nav_home);
        setBottomNav(navigationView);
    }

    private void setWatchingContinueRecyclerView(){
        continueWatchingAdapter = new ContinueWatchingAdapter(this, getMovie());
        rcvWatchingContinue.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvWatchingContinue.setAdapter(continueWatchingAdapter);
    }

    private void setGenreButtonRecyclerView(){
        categoryButtonAdapter = new GenreButtonAdapter(this);
        categoryButtonAdapter.setData(getListCategory());
        rcvGenreButton.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvGenreButton.setAdapter(categoryButtonAdapter);
    }

    private void setGenreMovieRecyclerView(){
        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter.setData(getListCategory());
        rcvCategoryImage.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcvCategoryImage.setNestedScrollingEnabled(false);
        rcvCategoryImage.setAdapter(categoryAdapter);
    }

//  Using init
    private void initUi(){
        viewPager2 = findViewById(R.id.viewPagerImageSlider2);
        rcvGenreButton = findViewById(R.id.rcv_btn_category);
        rcvCategoryImage = findViewById(R.id.rcv_category);
        navigationView = findViewById(R.id.bottom_navigation);
        rcvWatchingContinue = findViewById(R.id.rcv_continue_watching);
    }

//  Setup Image slide
    private void setImageSlider(ViewPager2 imageSlider, Handler handler){
        imageSlider.setAdapter(new SliderAdapter(getMovie(), viewPager2));
        imageSlider.setClipToPadding(false);
        imageSlider.setClipChildren(false);
        imageSlider.setOffscreenPageLimit(3);
        imageSlider.getChildAt(0).setOverScrollMode(RelativeLayout.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(0));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 0.25f*Math.abs(position);
                page.setScaleY(1-r);
            }
        });

        imageSlider.setPageTransformer(compositePageTransformer);
        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(sliderRunnable);
                handler.postDelayed(sliderRunnable,3000);
            }
        });

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        }
    };

    private void setBottomNav(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_favourite:
                        startActivity(new Intent(getApplicationContext(), FavouriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private List<CategoryMovie> getListCategory() {
        List<CategoryMovie> list = new ArrayList<>();

        list.add(new CategoryMovie("Most popular", getMovie()));
        list.add(new CategoryMovie("Action", getMovie()));
        list.add(new CategoryMovie("Comedy", getMovie()));
        list.add(new CategoryMovie("Romance", getMovie()));
        list.add(new CategoryMovie("Horror", getMovie()));
        return list;
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
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." ));
        imageMovieList.add(new Movie(
                "https://m.media-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_.jpg",
                "Frozen",
                "https://www.broadcastprome.com/wp-content/uploads/2020/07/Frozen-1.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://lumiere-a.akamaihd.net/v1/images/p_onward_19732_09862641.jpeg",
                "Onward",
                "https://www.showcasecinemas.com/Media/3032/onwardmobcall.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://static.tvtropes.org/pmwiki/pub/images/ralphbreakstheinternet.png",
                "Ralph Breaks the Internet",
                "https://images2.alphacoders.com/953/thumb-1920-953261.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        imageMovieList.add(new Movie(
                "https://static.wikia.nocookie.net/netflix/images/2/27/Sponge_on_the_Run_Poster.jpg",
                "SpongeBob SquarePants",
                "https://lrmonline.com/wp-content/uploads/2021/03/SpongeBobSpongeOnTheRun-3840x2160-1-scaled.jpg",
                "Action | adventure | S**",
                "2023 | 18+ | Season 1",
                crewList,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));

        return imageMovieList;
    }
}