package android.lucie.mymovies;

import android.lucie.mymovies.model.RestMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestMovieApi {

    @GET("pokemon")
    Call<RestMovieResponse> getListMovie();
}
