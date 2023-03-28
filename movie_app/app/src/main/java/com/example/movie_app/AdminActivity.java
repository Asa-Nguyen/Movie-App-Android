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
import com.example.movie_app.Model.Movie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {
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
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("movie_1",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        list.add(new Movie("movie_2",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        list.add(new Movie("movie_3",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        list.add(new Movie("movie_4",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        list.add(new Movie("movie_5",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        list.add(new Movie("movie_6",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/thumb%2Fsuzume_thumb.png?alt=media&token=b4175a9f-ea5f-4fb2-87bf-a9a82bdc3453",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/banner%2Fsuzeme_banner.jpg?alt=media&token=1cb850cc-97b2-4839-a87d-667df60e51d9",
                "Suzume no Tojimari",
                "\"The Locked Door of Suzume\" tells the story of Suzume who accidentally meets a young man who comes to her town in search of \"a door\". In order to protect Japan from disaster, the scattered doors all over the place must be closed, and unexpectedly, Suzume also has the special ability to close these doors. From then on, they both embark on the mission of \"locking the doors\" together!",
                "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5",
                18,
                2023,
                1,
                getCategorys()));
        for (Movie movie2: list) {
            Map<String, Object> map = new HashMap<>();
            map.put(movie2.getFuid(), getEpisodes());
            db.collection("episode").document(movie2.getFuid()).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("Creator", "DocumentSnapshot successfully written!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w("Creator", "Error writing document", e);
                }
            });
            map.clear();
            map.put(movie2.getFuid(), getCasts());
            db.collection("cast").document(movie2.getFuid()).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("Creator", "DocumentSnapshot successfully written!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w("Creator", "Error writing document", e);
                }
            });

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
            maps4.put("Fcategory",movie2.getFcategory());
            db.collection("movie").document(movie2.getFuid()).set(maps4).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("Creator", "DocumentSnapshot successfully written!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w("Creator", "Error writing document", e);
                }
            });

        }
    }

    private ArrayList<Map> getCasts(){
        ArrayList<Map> mapArrayList = new ArrayList<>();

        Map<String,String> map1 = new HashMap<>();
        map1.put("imageUrl", "https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/c2/Tobey_Maguire_2014.jpg&f=w");
        map1.put("nameCast", "Tobey Maguire");
        mapArrayList.add(map1);

        Map<String,String> map2 = new HashMap<>();
        map2.put("imageUrl", "https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/1/14/Willem_Dafoe_Cannes_2019.jpg&f=w");
        map2.put("nameCast", "Willem Dafoe");
        mapArrayList.add(map2);

        Map<String,String> map3 = new HashMap<>();
        map3.put("imageUrl", "https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/c/cf/James_Franco_4,_2013.jpg&f=w");
        map3.put("nameCast", "James Franco");
        mapArrayList.add(map3);

        Map<String,String> map4 = new HashMap<>();
        map4.put("imageUrl", "https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/e/e5/Joe_Manganiello_July_2015.jpg&f=w");
        map4.put("nameCast", "Joe Manganiello");
        mapArrayList.add(map4);

        Map<String,String> map5 = new HashMap<>();
        map5.put("imageUrl", "https://img-cache.coccoc.com/image?url=https://upload.wikimedia.org/wikipedia/commons/d/d4/Rosemary_Harris_Spiderman_2007_Shankbone.jpg&f=w");
        map5.put("nameCast", "Rosemary Harris");
        mapArrayList.add(map5);
        return mapArrayList;
    }

    private ArrayList<String> getCategorys() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Most popular");
        list.add("Action");
        list.add("Comedy");
        list.add("Romance");
        list.add("Horror");
        return list;
    }

    private ArrayList<Map> getEpisodes(){
        ArrayList<Map> mapArrayList = new ArrayList<>();

        Map<String, String> episodeList1 = new HashMap<>();
        episodeList1.put("nameMovie", "Chainsaw man");
        episodeList1.put("imageEpisode", "https://www.crunchyroll.com/imgsrv/display/thumbnail/1200x675/catalog/crunchyroll/91c8f9e4ddbcbcee7d8c12ace10e6dcf.jpe");
        episodeList1.put("episodeTitle", "E1 - DOG & CHAINSAW");
        episodeList1.put("playMovie", "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5");
        mapArrayList.add(episodeList1);

        Map<String, String> episodeList2 = new HashMap<>();
        episodeList2.put("nameMovie", "Chainsaw man");
        episodeList2.put("imageEpisode", "https://static.wikia.nocookie.net/chainsaw-man/images/0/07/Episode_2-1.png/revision/latest?cb=20221018090613");
        episodeList2.put("episodeTitle", "E2 - ARRIVAL IN TOKYO");
        episodeList2.put("playMovie", "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5");
        mapArrayList.add(episodeList2);

        Map<String, String> episodeList3 = new HashMap<>();
        episodeList3.put("nameMovie", "Chainsaw man");
        episodeList3.put("imageEpisode", "https://www.slashfilm.com/img/gallery/chainsaw-man-episode-3-is-an-action-packed-funny-and-gnarly/intro-1666735069.jpg");
        episodeList3.put("episodeTitle", "E3 -  MEOWY'S WHEREABOUTS");
        episodeList3.put("playMovie", "https://firebasestorage.googleapis.com/v0/b/movie-app-eb471.appspot.com/o/trailer%2Fsuzume_trailer.mp4?alt=media&token=66309807-f1b4-4180-8469-8c4cb2bb1ad5");
        mapArrayList.add(episodeList3);

        return mapArrayList;
    }





}
