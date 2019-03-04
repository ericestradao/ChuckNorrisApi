package com.example.user.chucknorrisapi.presenter;

import android.support.v7.widget.RecyclerView;

import com.example.user.chucknorrisapi.model.ChangeCharacterApi;
import com.example.user.chucknorrisapi.model.ChuckNorrisApiInterface;
import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.model.ConnectApi;
import com.example.user.chucknorrisapi.model.NeverEndingJokeApi;
import com.example.user.chucknorrisapi.model.Value;
import com.example.user.chucknorrisapi.view.ViewContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Presenter implements PresenterContract{
    final String TAG = Presenter.class.getSimpleName();
    ViewContract viewContract;

    public Presenter(ViewContract viewContract) {
        this.viewContract = viewContract;
    }


    @Override
    public void getRandomJoke() {
        Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
        ChuckNorrisApiInterface chuckNorrisApiInterface = retrofit.create(ChuckNorrisApiInterface.class);

        chuckNorrisApiInterface.getJokes().enqueue(new Callback<ChuckNorrisPojo>() {

            @Override
            public void onResponse(Call<ChuckNorrisPojo> call, Response<ChuckNorrisPojo> response) {
                viewContract.populateData(response.body());
            }

            @Override
            public void onFailure(Call<ChuckNorrisPojo> call, Throwable t) {
                viewContract.populateFail(t.getMessage());
            }
        });
    }

    @Override
    public void getCharacter(String[] firstName, String[] lastName) {
        Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
        ChangeCharacterApi changeCharacterApi = retrofit.create(ChangeCharacterApi.class);
        changeCharacterApi.getCharacter(firstName[0], lastName[1]).enqueue(new Callback<ChuckNorrisPojo>() {
            @Override
            public void onResponse(Call<ChuckNorrisPojo> call, Response<ChuckNorrisPojo> response) {
                viewContract.populateCharacter(response.body());
            }

            @Override
            public void onFailure(Call<ChuckNorrisPojo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getListJoke() {
    Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
    NeverEndingJokeApi neverEndingJokeApi = retrofit.create(NeverEndingJokeApi.class);
    neverEndingJokeApi.getList("20").enqueue(new Callback<ChuckNorrisPojo>() {
        @Override
        public void onResponse(Call<ChuckNorrisPojo> call, Response<ChuckNorrisPojo> response) {
            viewContract.populateListJoke(response.body());

        }

        @Override
        public void onFailure(Call<ChuckNorrisPojo> call, Throwable t) {

        }
    });

    }
}
