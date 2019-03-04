package com.example.user.chucknorrisapi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChangeCharacterApi {

    @GET("random?")
    Call<ChuckNorrisPojo> getCharacter (@Query("firstName") String fistName,
                                        @Query("lastName") String lastName);
}
