package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
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

import com.example.movie_app.Model.CastCrew.CastCrew;
import com.example.movie_app.Model.CategoryMovie.CategoryAdapter;
import com.example.movie_app.Model.CategoryMovie.CategoryButtonAdapter;
import com.example.movie_app.Model.CategoryMovie.CategoryMovie;
import com.example.movie_app.Model.ImageMovie.Movie;
import com.example.movie_app.Model.Slider.SliderAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFullActivity extends AppCompatActivity {
    // Variable for imageSlider
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    // Variable for rcvCategory Image
    private RecyclerView rcvCategoryImage;
    private CategoryAdapter categoryAdapter;
    // Variable for rcvCategory Button
    private RecyclerView rcvCategoryButton;
    private CategoryButtonAdapter categoryButtonAdapter;
    // Navigation
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefull);

        // Go to search activity

        // This function use for Image Slider
        viewPager2 = findViewById(R.id.viewPagerImageSlider2);
        // Setting adapter
        viewPager2.setAdapter(new SliderAdapter(getMovie(), viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RelativeLayout.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(0));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 0.25f*Math.abs(position);
                page.setScaleY(1-r);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });

        // RecyclerView Button
        rcvCategoryButton = findViewById(R.id.rcv_btn_category);
        categoryButtonAdapter = new CategoryButtonAdapter(this);

        LinearLayoutManager linearLayoutManagerButton = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvCategoryButton.setLayoutManager(linearLayoutManagerButton);

        categoryButtonAdapter.setData(getListCategory());
        rcvCategoryButton.setAdapter(categoryButtonAdapter);
        // RecyclerView ----------------
        rcvCategoryImage = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManagerImage = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategoryImage.setLayoutManager(linearLayoutManagerImage);
        rcvCategoryImage.setNestedScrollingEnabled(false);
        categoryAdapter.setData(getListCategory());
        rcvCategoryImage.setAdapter(categoryAdapter);
        // -----------------------------

        // Bottom navigation

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_trend:
                        startActivity(new Intent(getApplicationContext(), TrendingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_watch_late:
                        startActivity(new Intent(getApplicationContext(), WatchLateActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    public void onSearchActivity(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
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
                "How to Train Your Dragon",
                "https://highlightsalongtheway.com/wp-content/uploads/2019/02/DR3_StandeeWebArt_RGB_1-scaled.jpg",
                "Action | adventure | S**",
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

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        }
    };
}