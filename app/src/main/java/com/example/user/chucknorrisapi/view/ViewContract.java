package com.example.user.chucknorrisapi.view;

import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.model.NeverEndingPojo;

public interface ViewContract {
    void populateData(ChuckNorrisPojo chuckNorrisPojo);
    void populateFail(String errorMessage);
    void populateCharacter(ChuckNorrisPojo chuckNorrisPojo);
    void populateListJoke(NeverEndingPojo neverEndingPojo);
}
