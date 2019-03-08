package android.lucie.mymovies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.lucie.mymovies.model.Movie;
import android.lucie.mymovies.model.RestMovieResponse;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;
    private RestMovieApi restMovieApi;

    static final String BASE_URL = "https://swapi.co/api/";

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restMovieApi = retrofit.create(RestMovieApi.class);

        //if (hasDataInDataBase()) {
            List<Movie> peopleList = getListFromDataBase();
            activity.showList(peopleList);
        //} else {
            makeApiCall();
        //}
    }

    private void makeApiCall() {
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

    private void storeData(List<Movie> listMovie) {
        //TODO
    }

    private List<Movie> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }


}
