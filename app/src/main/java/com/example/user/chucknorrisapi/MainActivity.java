package com.example.user.chucknorrisapi;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.user.chucknorrisapi.model.ChuckNorrisPojo;
import com.example.user.chucknorrisapi.model.NeverEndingPojo;
import com.example.user.chucknorrisapi.presenter.Presenter;
import com.example.user.chucknorrisapi.view.Adapter;
import com.example.user.chucknorrisapi.view.NeverEndingFragment;
import com.example.user.chucknorrisapi.view.RandomJokeFragment;
import com.example.user.chucknorrisapi.view.TabAdapter;
import com.example.user.chucknorrisapi.view.TextInputFragment;
import com.example.user.chucknorrisapi.view.ViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewContract {
    final String TAG = MainActivity.class.getSimpleName();
    Presenter presenter;
    Adapter adapter;
    RecyclerView recyclerView;

    private TabAdapter tabAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.firstTab);

        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new RandomJokeFragment(), "Random Joke");
        tabAdapter.addFragment(new TextInputFragment(), "Change Character");
        tabAdapter.addFragment(new NeverEndingFragment(), "List of Jokes");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //     ButterKnife.bind(this);

        presenter = new Presenter(this);
        //presenter.getRandomJoke();
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (tabAdapter.getItem(position) instanceof RandomJokeFragment) {
                    presenter.getRandomJoke();
                    Log.d(TAG, "rocklayout");
                } else if (tabAdapter.getItem(position) instanceof TextInputFragment) {
                    //presenter.getClassicMusic();
                    Log.d(TAG, "classiclayout");
                } else if (tabAdapter.getItem(position) instanceof NeverEndingFragment) {
                    presenter.getListJoke();
                    Log.d(TAG, "poplayout");
                }
            }
        });

    }

    @Override
    public void populateData(ChuckNorrisPojo chuckNorrisPojo) { }
    @Override
    public void populateFail(String errorMessage) { }
    @Override
    public void populateCharacter(ChuckNorrisPojo chuckNorrisPojo) { }

    @Override
    public void populateListJoke(NeverEndingPojo neverEndingPojo) {
        adapter = new Adapter(neverEndingPojo, this);
        recyclerView = findViewById(R.id.rv_joke_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
