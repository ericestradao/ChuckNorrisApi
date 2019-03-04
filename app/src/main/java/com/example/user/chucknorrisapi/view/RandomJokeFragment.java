package com.example.user.chucknorrisapi.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.chucknorrisapi.R;
import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomJokeFragment extends Fragment implements ViewContract{
    final String TAG = RandomJokeFragment.class.getSimpleName();

    Presenter presenter;
    @BindView(R.id.RandomJoke)
    TextView tv_random;
    @BindView(R.id.newJoke)
    Button newJoke;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.random_joke, container, false);

        ButterKnife.bind(this, view);
        presenter = new Presenter(this);
        presenter.getRandomJoke();
        newJoke.setOnClickListener(event -> newJokeEvent());
        return view;
        //return inflater.inflate(R.layout.random_joke, container, false);

    }

    private void newJokeEvent() {
        presenter.getRandomJoke();
    }

    @Override
    public void populateData(ChuckNorrisPojo chuckNorrisPojo) {
        Log.d(TAG, "populateData: ");
        tv_random.setText(chuckNorrisPojo.getValue().getJoke());
    }

    @Override
    public void populateFail(String errorMessage) {}
    @Override
    public void populateCharacter(ChuckNorrisPojo chuckNorrisPojo) { }
    @Override
    public void populateListJoke(ChuckNorrisPojo chuckNorrisPojo){}
}
