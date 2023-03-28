package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.Adapter.FavoriteAdapter;
import com.example.movie_app.Database.DataLocalManager;
import com.example.movie_app.Model.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    private FavoriteAdapter favoriteAdapter;
    private RecyclerView favoriteRecyclerView;
    private BottomNavigationView navigationView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference movieRef = db.collection("movie");
    private DatabaseReference favoriteRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://movie-app-eb471-default-rtdb.firebaseio.com/users/" + DataLocalManager.getUserUid() + "/favorite");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        unitUi();
        // Bottom nav
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_favourite);
        setBottomNav(navigationView);


        favoriteRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Movie> favoriteData = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Movie movie = snapshot.getValue(Movie.class);
                    favoriteData.add(movie);
                }
                setUpFavoriteRecyclerView(favoriteData);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Creator", "Error get favorite");
            }
        });
    }

    private void setUpFavoriteRecyclerView(List<Movie> favoriteData){
        favoriteAdapter = new FavoriteAdapter(this, favoriteData);
        favoriteRecyclerView.setHasFixedSize(true);
        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        favoriteRecyclerView.setAdapter(favoriteAdapter);
        favoriteAdapter.notifyDataSetChanged();
    }

    private void unitUi(){
        favoriteRecyclerView = (RecyclerView) findViewById(R.id.fav_rcv);
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
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}