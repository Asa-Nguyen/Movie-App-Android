package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.Adapter.CollectionAdapter;
import com.example.movie_app.Database.Database;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView collectionRecyclerView;
    private CollectionAdapter collectionAdapter;
    private BottomNavigationView navigationView;
    private Button buttonMovieList, buttonWatched, buttonMyReview, buttonSetting, buttonLogout;
    private FirebaseFirestore realtimeRef = FirebaseFirestore.getInstance();
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initUi();
        onClickButtonSetting();

        realtimeRef.collection("movie").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            private static final String TAG = "movie";
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        Log.d(TAG, document.getId() + "=>" + document.getData());
                    }
                    Toast.makeText(ProfileActivity.this, "Add category successfully", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ProfileActivity.this, "Add category successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_account);

        setBottomNav(navigationView);
//        setCollectionRecyclerView();
    }

    private void onClickButtonSetting() {
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initUi() {
        collectionRecyclerView = (RecyclerView) findViewById(R.id.collectionRecyclerView);
        buttonMovieList = (Button) findViewById(R.id.profile_button_animelist);
        buttonWatched = (Button) findViewById(R.id.profile_button_watched);
        buttonMyReview = (Button) findViewById(R.id.profile_button_my_review);
        buttonSetting = (Button) findViewById(R.id.profile_button_setting);
        buttonLogout = (Button) findViewById(R.id.profile_button_logout);
    }

    private void onClickButtonLogout(){
        buttonMovieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onClickButtonMyReview(){
        buttonWatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onClickButtonMyWatched(){
        buttonMyReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onClickButtonMovieList(){
        buttonMovieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

//    private void onClickButtonSetting(){
//        buttonSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfileActivity.this, AdminActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void setCollectionRecyclerView() {
        collectionAdapter = new CollectionAdapter(this, db.getMovie2Db());
        collectionRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        collectionRecyclerView.setAdapter(collectionAdapter);
    }

    private void setBottomNav(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomeFullActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_favourite:
                        startActivity(new Intent(getApplicationContext(), FavouriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_account:
                        return true;
                }
                return false;
            }
        });
    }
}