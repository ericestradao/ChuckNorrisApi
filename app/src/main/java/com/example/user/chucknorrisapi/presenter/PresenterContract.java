package com.example.user.chucknorrisapi.presenter;

public interface PresenterContract {
    void getRandomJoke();
    void getCharacter(String[] firstName, String[] lastName);
    void getListJoke();
}
