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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.chucknorrisapi.R;
import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextInputFragment extends Fragment implements ViewContract{
    Presenter presenter;
    @BindView(R.id.text_input)
    EditText text_input;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.ChangeCharacter)
    TextView ChangeCharacter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_character, container, false);

        ButterKnife.bind(this, view);
        presenter = new Presenter(this);
        submit.setOnClickListener(event -> newCharacter());


        return view;
    }

    private void newCharacter() {
        String name = text_input.getText().toString();

        if (name.contains(" ")) {
            String[] names = name.split("\\s+");

            presenter.getCharacter(names, names);
        }
        else{
            Toast.makeText(getContext(),"Insert a last name", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void populateData(ChuckNorrisPojo chuckNorrisPojo) {}
    @Override
    public void populateFail(String errorMessage) {}

    @Override
    public void populateCharacter(ChuckNorrisPojo chuckNorrisPojo) {
       // Log.d(TAG, "populateData: ");
        ChangeCharacter.setText(chuckNorrisPojo.getValue().getJoke());
    }

    @Override
    public void populateListJoke(ChuckNorrisPojo chuckNorrisPojo) {}
}
