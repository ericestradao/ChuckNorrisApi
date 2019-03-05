package com.example.user.chucknorrisapi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.chucknorrisapi.R;
import com.example.user.chucknorrisapi.model.ChuckNorrisApiInterface;
import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.model.NeverEndingPojo;

import java.util.Iterator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    NeverEndingPojo listJoke;
    Context context;

    final String TAG = RandomJokeFragment.class.getSimpleName();

    public Adapter(NeverEndingPojo listJoke, Context context){
        this.listJoke = listJoke;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     //   for (i = 0; i < listJoke.getValue().getJoke().length(); i++) {
            viewHolder.tv_joke.setText(listJoke.getValue().get(i).getJoke());

    //    }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return listJoke.getValue().size();
    }
}
