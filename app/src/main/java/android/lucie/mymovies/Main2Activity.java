package android.lucie.mymovies;

import android.content.Intent;
import android.lucie.mymovies.model.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";
    private static final String NAME = "showTextView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();


        /*
        peopleName = findViewById(R.id.name);
        Movie movie = (Movie) getIntent().getSerializableExtra(MainActivity.NAME);
*/
        //loadDetails(movie);
        //showName();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra(NAME)){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String peopleName = getIntent().getStringExtra(NAME);
            setName(peopleName);
        }
    }

    private void setName(String peopleName){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.name);
        name.setText(peopleName);
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
