package android.lucie.mymovies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.lucie.mymovies.model.Movie;
import android.lucie.mymovies.model.Movie;

import android.app.Activity;
import android.lucie.mymovies.model.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

    private static final String PREFS = "PREFS";
    private static final String PREFS_AGE = "PREFS_AGE";
    private static final String PREFS_NAME = "PREFS_NAME";
    SharedPreferences sharedPreferences;

    private static final String NAME = "showTextView";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();

        sharedPreferences();
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


    public void sharedPreferences(){
        sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);

        //objectif : sauvegarder 1 seule fois le nom et l'age de l'utilisateur

        //pour cela, on commence par regarder si on a déjà des éléments sauvegardés
        if (sharedPreferences.contains(PREFS_AGE) && sharedPreferences.contains(PREFS_NAME)) {

            int age = sharedPreferences.getInt(PREFS_AGE, 0);
            String name = sharedPreferences.getString(PREFS_NAME, null);

            Toast.makeText(this, "Age: " + age + " name: " + name, Toast.LENGTH_SHORT).show();

        } else {
            sharedPreferences
                    .edit()
                    .putInt(PREFS_AGE, 20)
                    .putString(PREFS_NAME, "moi")
                    .apply();

            Toast.makeText(this, "Sauvegardé, relancez l'application pour voir le résultat", Toast.LENGTH_SHORT).show();
        }
    }

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Hello Toast!",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    /*
    public void onClickDetails (View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        TextView showTextView = (TextView) findViewById(R.id.name);
        String str = showTextView.getText().toString();
        intent.putExtra(NAME, str);
        startActivity(intent);
    }
    */
}
