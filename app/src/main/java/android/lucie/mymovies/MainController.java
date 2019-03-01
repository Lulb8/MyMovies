package android.lucie.mymovies;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.lucie.mymovies.model.Movie;
import android.lucie.mymovies.model.RestMovieResponse;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dĂ©pendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestMovieApi restMovieApi = retrofit.create(RestMovieApi.class);

        Call<RestMovieResponse> call = restMovieApi.getListMovie();
        call.enqueue(new Callback<RestMovieResponse>() {
            @Override
            public void onResponse(Call<RestMovieResponse> call, Response<RestMovieResponse> response) {
                RestMovieResponse restMovieResponse = response.body();
                List<Movie> listMovie = restMovieResponse.getResults();
                activity.showList(listMovie);
            }

            @Override
            public void onFailure(Call<RestMovieResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}
