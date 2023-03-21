package com.example.movie_app.Database;

import androidx.annotation.NonNull;

import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Model.CategoryMovie;
import com.example.movie_app.Model.Movie2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Database {
    private List<Movie2> movieDatabase;
    private List<CategoryMovie> categoryMovieDatabase;
    private List<CastCrew> castCrewDatabase;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://movie-app-eb471-default-rtdb.firebaseio.com/");
    public void setMovieDb(){
        databaseReference = databaseReference.child("cast");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    castCrewDatabase.add(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public List<Movie2> getMovieDatabase() {
        return movieDatabase;
    }

    public List<CategoryMovie> getCategoryMovieDatabase() {
        return categoryMovieDatabase;
    }
}
