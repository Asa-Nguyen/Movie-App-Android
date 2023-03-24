package com.example.movie_app.Database;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.movie_app.AdminActivity;
import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Model.CategoryMovie;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Movie2> movie2Db;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public  Database(){
        List<Movie2> movie2s = new ArrayList<>();
        db.collection("movie").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            private static final String TAG = "movie";
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        movie2s.add(document.toObject(Movie2.class));
                    }
                }
            }
        });
        setCast(movie2s);
//        setCategory(movie2s);
        setEpisode(movie2s);
        this.movie2Db = movie2s;
    }

//    private void setCategory(List<Movie2> list){
//        int i = 0;
//        for(Movie2 movie2 : list){
//            String getI = Integer.toString(i++);
//            db.collection("category").document(movie2.getFuid()).collection("category_" +getI).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                    if(task.isSuccessful()){
//                        List<CategoryMovie> categoryMovies = new ArrayList<>();
//                        for(QueryDocumentSnapshot document : task.getResult()){
//                            categoryMovies.add(document.toObject(CategoryMovie.class));
//                        }
//                        movie2.setCcategory(categoryMovies);
//                    }
//                }
//            });
//        }
//    }

    private void setCast(List<Movie2> list){
        int i = 0;
        for(Movie2 movie2 : list){
            String getI = Integer.toString(i++);
            db.collection("cast").document(movie2.getFuid()).collection("cast_" +getI).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        List<CastCrew> castCrewList = new ArrayList<>();
                        for(QueryDocumentSnapshot document : task.getResult()){
                            castCrewList.add(document.toObject(CastCrew.class));
                        }
                        movie2.setCcast(castCrewList);
                    }
                }
            });
        }
    }

    private void setEpisode(List<Movie2> list){
        int i = 0;
        for(Movie2 movie2 : list){
            String getI = Integer.toString(i++);
            db.collection("episode").document(movie2.getFuid()).collection("episode_" +getI).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        List<Episode> episodeList = new ArrayList<>();
                        for(QueryDocumentSnapshot document : task.getResult()){
                            episodeList.add(document.toObject(Episode.class));
                        }
                        movie2.setEepisode(episodeList);
                    }
                }
            });
        }
    }

    public List<Movie2> getMovie2Db(String s) {
        return movie2Db;
    }

    public void setMovie2Db(List<Movie2> movie2Db) {
        this.movie2Db = movie2Db;
    }
}
