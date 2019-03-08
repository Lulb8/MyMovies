package android.lucie.mymovies;

import android.content.Intent;
import android.lucie.mymovies.model.Movie;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;
    private static List<Movie> movieList;

    private static final String NAME = "showTextView";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();

    }

    public void showList(List<Movie> input){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MovieAdapter(input, getListener(), this);
        recyclerView.setAdapter(mAdapter);
    }

    private MovieAdapter.OnItemClickListener getListener() {
        return new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Gson gson = new Gson();
                String json = gson.toJson(movie);
                intent.putExtra(NAME, json);
                startActivity(intent);
            }
        };

    }
}
