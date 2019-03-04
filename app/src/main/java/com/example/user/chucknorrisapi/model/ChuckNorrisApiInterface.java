package com.example.user.chucknorrisapi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChuckNorrisApiInterface {
    @GET("random")
    Call<ChuckNorrisPojo> getJokes ();

}
