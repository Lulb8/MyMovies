package android.lucie.mymovies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.lucie.mymovies.model.People;
import android.lucie.mymovies.model.RestPeopleResponse;
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
            List<People> peopleList = getListFromDataBase();
            activity.showList(peopleList);
        //} else {
            makeApiCall();
        //}
    }

    private void makeApiCall() {
        Call<RestPeopleResponse> call = restMovieApi.getListPeople();
        call.enqueue(new Callback<RestPeopleResponse>() {
            @Override
            public void onResponse(Call<RestPeopleResponse> call, Response<RestPeopleResponse> response) {
                RestPeopleResponse restMovieResponse = response.body();
                List<People> listPeople = restMovieResponse.getResults();
                activity.showList(listPeople);
            }

            @Override
            public void onFailure(Call<RestPeopleResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

    private void storeData(List<People> listPeople) {
        //TODO
    }

    private List<People> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }


}
