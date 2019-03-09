package android.lucie.mymovies;

import android.lucie.mymovies.model.People;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

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

        TextView birthYear = findViewById(R.id.birth_year);
        birthYear.setText("Birth Year : " + people.getBirthYear());

        TextView eyeColor = findViewById(R.id.eye_color);
        eyeColor.setText("Eye color : " + people.getEyeColor());

        TextView gender = findViewById(R.id.gender);
        gender.setText("Gender : " + people.getGender());

        TextView hairColor = findViewById(R.id.hair_color);
        hairColor.setText("Hair color : " + people.getHairColor());

        TextView height = findViewById(R.id.height);
        height.setText("Height : " + people.getHeight() + " cm");

        TextView mass = findViewById(R.id.mass);
        mass.setText("Mass : " + people.getMass() + " kg");

        TextView skinColor = findViewById(R.id.skin_color);
        skinColor.setText("Skin color : " + people.getSkinColor());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}