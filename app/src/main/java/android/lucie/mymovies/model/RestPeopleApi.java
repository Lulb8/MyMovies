package android.lucie.mymovies.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPeopleApi {

    @GET("people.json")
    Call<RestPeopleResponse> getListPeople();

}
