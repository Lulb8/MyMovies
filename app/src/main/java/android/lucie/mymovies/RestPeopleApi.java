package android.lucie.mymovies;

import android.lucie.mymovies.model.RestPeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPeopleApi {

    @GET("people")
    Call<RestPeopleResponse> getListPeople();

}
