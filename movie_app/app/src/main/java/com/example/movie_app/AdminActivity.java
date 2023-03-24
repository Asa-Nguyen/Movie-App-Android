package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movie_app.Model.CastCrew;
import com.example.movie_app.Model.CategoryMovie;
import com.example.movie_app.Model.Episode;
import com.example.movie_app.Model.Movie2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {
    private static final String TAG = "Quan que";
    private Button add, back;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        add = findViewById(R.id.button_add_movie);
        back = findViewById(R.id.button_back_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, HomeFullActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCollection();
            }
        });
    }


    public void setCollection(){
        List<Movie2> list = new ArrayList<>();
        list.add(new Movie2("movie_1",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        list.add(new Movie2("movie_2",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        list.add(new Movie2("movie_3",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        list.add(new Movie2("movie_4",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        list.add(new Movie2("movie_5",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        list.add(new Movie2("movie_6",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getEpisodes(),
                getCasts(),
                getCategorys()));
        for (Movie2 movie2: list) {
            int i = 0;
            for(Episode episode: movie2.getEepisode()){
                String getI = Integer.toString(i++);
                Map<String, Object> maps1 = new HashMap<>();
                maps1.put("nameMovie", episode.getNameMovie());
                maps1.put("imageEpisode", episode.getImageEpisode());
                maps1.put("episodeTitle", episode.getEpisodeTitle());
                maps1.put("playMovie", episode.getPlayMovie());
                maps1.put("isCheck", episode.getIsCheck());
                db.collection("episode").document(movie2.getFuid()).collection("episode_" +getI).document(getI).set(maps1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AdminActivity.this, "Add episode successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AdminActivity.this, "Fail1 :)", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            i = 0;
            for(CastCrew castCrew: movie2.getCcast()){
                String getI = Integer.toString(i++);
                Map<String, Object> maps1 = new HashMap<>();
                maps1.put("Cimage", castCrew.getCimage());
                maps1.put("Cname", castCrew.getCname());
                db.collection("cast").document(movie2.getFuid()).collection(  "cast_" + getI).document(getI).set(maps1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AdminActivity.this, "Add cast successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AdminActivity.this, "Fail2 :)", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            i = 0;
            for(CategoryMovie categoryMovie: movie2.getCcategory()){
                String getI = Integer.toString(i++);
                Map<String, Object> maps1 = new HashMap<>();
                maps1.put("nameCategory", categoryMovie.getNameCategory());
                db.collection("category").document(movie2.getFuid()).collection("category_" +getI).document(getI).set(maps1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AdminActivity.this, "Add category successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AdminActivity.this, "Fail3 :)", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }



            Map<String, Object> maps4 = new HashMap<>();
            maps4.put("Fuid", movie2.getFuid());
            maps4.put("Fthumb", movie2.getFthumb());
            maps4.put("Fname", movie2.getFname());
            maps4.put("Fsynopsis", movie2.getFsynopsis());
            maps4.put("FvideoTrailer", movie2.getFvideoTrailer());
            maps4.put("Ftrailer", movie2.getFtrailer());
            maps4.put("Fmmpa", movie2.getFmmpa());
            maps4.put("Fyear", movie2.getFyear());
            maps4.put("Fseason", movie2.getFseason());
            db.collection("movie").document(movie2.getFuid()).set(maps4).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "DocumentSnapshot successfully written!");
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error writing document", e);
                        }
                    });

        }
    }

    private List<CastCrew> getCasts(){
        List<CastCrew> crewList = new ArrayList<>();
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/c2/Tobey_Maguire_2014.jpg&f=w", "Tobey Maguire"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/1/14/Willem_Dafoe_Cannes_2019.jpg&f=w", "Willem Dafoe"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/cf/James_Franco_4,_2013.jpg&f=w", "James Franco"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/e/e5/Joe_Manganiello_July_2015.jpg&f=w", "Joe Manganiello"));
        crewList.add(new CastCrew("https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/d/d4/Rosemary_Harris_Spiderman_2007_Shankbone.jpg&f=w", "Rosemary Harris"));
        return crewList;
    }

    private List<CategoryMovie> getCategorys() {
        List<CategoryMovie> list = new ArrayList<>();

        list.add(new CategoryMovie("Most popular"));
        list.add(new CategoryMovie("Action"));
        list.add(new CategoryMovie("Comedy"));
        list.add(new CategoryMovie("Romance"));
        list.add(new CategoryMovie("Horror"));
        return list;
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





}
