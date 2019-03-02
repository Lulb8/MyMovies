package android.lucie.mymovies;

import android.lucie.mymovies.model.RestMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestMovieApi {

/*
    @GET("pokemon/?offset=0&limit=964")
    Call<RestMovieResponse> getListMovie();
*/

    @GET("people")  /*page 1 à 9*/
    Call<RestMovieResponse> getListMovie();

}
