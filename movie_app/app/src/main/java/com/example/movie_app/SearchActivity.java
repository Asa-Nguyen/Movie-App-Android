package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.Model.CastCrew.CastCrew;
import com.example.movie_app.Model.ImageMovie.GridViewApdater;
import com.example.movie_app.Model.ImageMovie.Movie;
import com.example.movie_app.Model.ImageMovie.SearchMovieAdapter;
import com.example.movie_app.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private SearchView searchView;
    private RecyclerView recyclerViewSearch;

//  ArrayList search
    ArrayList<Movie> searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//      Grid view
        final GridView gridView = findViewById(R.id.grid_view_search);
        gridView.setAdapter(new GridViewApdater(this, getMovie()));

//      Search view
//        searchView = findViewById(R.id.search_view);
//        recyclerViewSearch.findViewById(R.id.search_rcv);
//        searchView.clearFocus();
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
//        recyclerViewSearch.setLayoutManager(layoutManager);
//        SearchMovieAdapter searchMovieAdapter = new SearchMovieAdapter(this, getMovie());
//        recyclerViewSearch.setAdapter(searchMovieAdapter);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchList = new ArrayList<>();
//                if(query.length() > 0){
//                    for (int i = 0; i < getMovie().size(); ++i){
//                        if(getMovie().get(i).getNameMovie().toUpperCase().contains(query.toUpperCase())){
//                            searchList.add(getMovie().get(i));
//                        }
//                    }
//                    RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(SearchActivity.this);
//                    recyclerViewSearch.setLayoutManager(layoutManager1);
//
//                    SearchMovieAdapter searchMovieAdapter1 = new SearchMovieAdapter(SearchActivity.this, searchList);
//                    recyclerViewSearch.setAdapter(searchMovieAdapter1);
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        

//      Bottom navigation //
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_search);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomeFullActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_search:
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
}