package com.example.user.chucknorrisapi.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.chucknorrisapi.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tv_joke;

    public ViewHolder(@NonNull View jokeView) {
        super(jokeView);
        tv_joke = jokeView.findViewById(R.id.tv_joke);
    }
}
