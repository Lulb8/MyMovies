package android.lucie.mymovies.view;

import android.content.Intent;
import android.lucie.mymovies.R;
import android.lucie.mymovies.controller.MainController;
import android.lucie.mymovies.model.People;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;

    private static final String NAME = "showTextView";
    private static final String PREFS = "PREFS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        final MediaPlayer soundStart = MediaPlayer.create(getApplicationContext(), R.raw.lightsaber_on);
        soundStart.start();

        controller = new MainController(this, getBaseContext().getSharedPreferences(PREFS,MODE_PRIVATE));
        controller.onStart();
    }

    public void showList(List<People> input){
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new PeopleAdapter(input, getListener(), this);
        recyclerView.setAdapter(mAdapter);
    }

    private PeopleAdapter.OnItemClickListener getListener() {
        return new PeopleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(People people) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Gson gson = new Gson();
                String json = gson.toJson(people);
                intent.putExtra(NAME, json);
                startActivity(intent);

                final MediaPlayer soundNext = MediaPlayer.create(getApplicationContext(), R.raw.lightsaber_next);
                soundNext.start();

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        };
    }

    @Override
    public void finish() {
        super.finish();
        final MediaPlayer soundPrevious = MediaPlayer.create(getApplicationContext(), R.raw.lightsaber_previous);
        soundPrevious.start();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
