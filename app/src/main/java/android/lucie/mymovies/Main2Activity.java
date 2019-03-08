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
    private TextView peopleName;

    private static List<Movie> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String json = getIntent().getStringExtra("showTextView");
        Gson gson = new Gson();
        Movie movie = gson.fromJson(json,Movie.class);
        TextView name = findViewById(R.id.name);
        name.setText(movie.getName());


        /*
        peopleName = findViewById(R.id.name);
        Movie movie = (Movie) getIntent().getSerializableExtra(MainActivity.NAME);
*/
        //loadDetails(movie);
        //showName();
    }

    /*
    public void showName () {
        Intent intent = getIntent();
        // Get the text view where the name will be displayed
        TextView textView = (TextView) findViewById(R.id.name);
        // Get the name from the intent extras
        String myName = intent.getStringExtra(NAME);
        // Generate the random number
        String text = "";
        text = myName;
        // Display the name.
        textView.setText(text);


        Intent intent = getIntent();
        if (intent != null) {
            String str = "";
            if (intent.hasExtra("showTextView")) {
                str = intent.getStringExtra("showTextView");
            }
            TextView textView = (TextView) findViewById(R.id.name);
        }
   }*/
/*
    private void loadDetails(Movie movie){
        movie.setName(movie.getName());
    }
    */

}
