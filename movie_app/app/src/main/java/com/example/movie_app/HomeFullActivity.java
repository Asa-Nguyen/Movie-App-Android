package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import com.example.movie_app.Model.CategoryMovie.CategoryAdapter;
import com.example.movie_app.Model.CategoryMovie.CategoryMovie;
import com.example.movie_app.Model.Movie.Movie;
import com.example.movie_app.Model.Slider.SliderAdapter;
import com.example.movie_app.Model.Slider.SliderItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFullActivity extends AppCompatActivity {
    // Variable for imageSlider
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    // Variable for rvcCategory
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    // Navigation
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefull);

        // This function use for Image Slider
        viewPager2 = findViewById(R.id.viewPagerImageSlider2);
        List<SliderItem> sliderItems = new ArrayList<>();
        // Add image
        sliderItems.add(new SliderItem(R.drawable.banner_1));
        sliderItems.add(new SliderItem(R.drawable.banner_2));
        sliderItems.add(new SliderItem(R.drawable.banner_3));
        // Setting adapter
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

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
        // RecyclerView

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

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

    private List<CategoryMovie> getListCategory() {
        List<CategoryMovie> list = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(R.drawable.pos_dragon, "Movie 1"));
        movieList.add(new Movie(R.drawable.pos_froze, "Movie 1"));
        movieList.add(new Movie(R.drawable.pos_onward, "Movie 1"));
        movieList.add(new Movie(R.drawable.pos_ralph, "Movie 1"));
        movieList.add(new Movie(R.drawable.pos_dragon, "Movie 1"));
        movieList.add(new Movie(R.drawable.pos_spongebob, "Movie 1"));

        list.add(new CategoryMovie("Cartoon", movieList));
        list.add(new CategoryMovie("18+", movieList));
        list.add(new CategoryMovie("Horror", movieList));
        return list;
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        }
    };
}