package android.lucie.mymovies;

import android.content.Intent;
import android.lucie.mymovies.model.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String NAME = "showTextView";

    private static List<Movie> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String json = getIntent().getStringExtra(NAME);
        Gson gson = new Gson();
        Movie movie = gson.fromJson(json,Movie.class);

        TextView name = findViewById(R.id.name);
        name.setText(movie.getName());

        TextView gender = findViewById(R.id.gender);
        gender.setText("Gender : " + movie.getGender());

        TextView hairColor = findViewById(R.id.hair_color);
        hairColor.setText("Hair color : " + movie.getHairColor());
/*
        TextView homeworld = findViewById(R.id.homeworld);
        homeworld.setText("Homeworld : " + movie.getHomeworld());
*/
        TextView birthYear = findViewById(R.id.birth_year);
        birthYear.setText("Birth Year : " + movie.getBirthYear());

    }
}
