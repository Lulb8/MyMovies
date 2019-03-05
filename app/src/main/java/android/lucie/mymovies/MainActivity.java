package android.lucie.mymovies;

import android.content.Intent;
import android.content.SharedPreferences;
import android.lucie.mymovies.model.Movie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

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
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MovieAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    public void onClickDetails (View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        TextView showTextView = (TextView) findViewById(R.id.name);
        String str = showTextView.getText().toString();
        intent.putExtra(NAME, str);
        startActivity(intent);
    }

}
