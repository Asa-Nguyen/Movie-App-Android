package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import com.example.movie_app.Database.Database;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Adapter.CategoryAdapter;
import com.example.movie_app.Adapter.GenreButtonAdapter;
import com.example.movie_app.Model.CategoryList;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.Adapter.SliderAdapter;
import com.example.movie_app.Model.Movie2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class HomeFullActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    private RecyclerView rcvCategoryImage, rcvGenreButton, rcvWatchingContinue;
    private BottomNavigationView navigationView;
    // Adapter
    private CategoryAdapter categoryAdapter;
    private GenreButtonAdapter categoryButtonAdapter;
    private ContinueWatchingAdapter continueWatchingAdapter;
    // Model
    private List<Movie> movieList;
    private DatabaseReference featured = FirebaseDatabase.getInstance().getReference("featured");
    // Database
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Movie2> movie2s = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefull);
        initUi();

        CollectionReference movieRef = db.collection("movie");
        movieRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<Movie2> list = new ArrayList<>();
                    for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        Movie2 movie2 = documentSnapshot.toObject(Movie2.class);
                        Log.d("Creator", movie2.toString());
                        list.add(movie2);
                    }
                    setImageSlider(viewPager2, sliderHandler, list);
                    setWatchingContinueRecyclerView(list);
                    setGenreButtonRecyclerView(list);
                    setGenreMovieRecyclerView(list);
                }
            }
        });
              
        navigationView.setSelectedItemId(R.id.nav_home);
        setBottomNav(navigationView);

    }

    private void setWatchingContinueRecyclerView(List<Movie2> movie2List){
        continueWatchingAdapter = new ContinueWatchingAdapter(this, movie2List);
        rcvWatchingContinue.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvWatchingContinue.setAdapter(continueWatchingAdapter);
    }

    private void setGenreButtonRecyclerView(List<Movie2>movie2List){
        categoryButtonAdapter = new GenreButtonAdapter(this);
        categoryButtonAdapter.setData(getListCategory(movie2List));
        rcvGenreButton.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcvGenreButton.setAdapter(categoryButtonAdapter);
    }

    private void setGenreMovieRecyclerView(List<Movie2> movie2List){
        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter.setData(getListCategory(movie2List));
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
    private void setImageSlider(ViewPager2 imageSlider, Handler handler, List<Movie2> movie2List){
        imageSlider.setAdapter(new SliderAdapter(movie2List, viewPager2));
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

    private List<CategoryList> getListCategory(List<Movie2> movie2List) {
        List<CategoryList> list = new ArrayList<>();

        list.add(new CategoryList("Most popular", movie2List));
        list.add(new CategoryList("Action", movie2List));
        list.add(new CategoryList("Comedy", movie2List));
        list.add(new CategoryList("Romance", movie2List));
        list.add(new CategoryList("Horror", movie2List));
        return list;
    }
}
