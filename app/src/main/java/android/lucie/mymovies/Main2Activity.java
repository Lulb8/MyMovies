package android.lucie.mymovies;

import android.lucie.mymovies.model.People;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String NAME = "showTextView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String json = getIntent().getStringExtra(NAME);
        Gson gson = new Gson();
        People people = gson.fromJson(json, People.class);

        TextView name = findViewById(R.id.name);
        name.setText(people.getName());

        TextView gender = findViewById(R.id.gender);
        gender.setText("Gender : " + people.getGender());

        TextView hairColor = findViewById(R.id.hair_color);
        hairColor.setText("Hair color : " + people.getHairColor());
/*
        TextView homeworld = findViewById(R.id.homeworld);
        homeworld.setText("Homeworld : " + people.getHomeworld());
*/
        TextView birthYear = findViewById(R.id.birth_year);
        birthYear.setText("Birth Year : " + people.getBirthYear());

    }
}
