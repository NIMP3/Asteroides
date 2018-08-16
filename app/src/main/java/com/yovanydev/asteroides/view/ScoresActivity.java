package com.yovanydev.asteroides.view;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import com.yovanydev.asteroides.MenuActivity;
import com.yovanydev.asteroides.R;
import com.yovanydev.asteroides.adapter.ScoreAdapterRecyclerView;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        showToolbar(getResources().getString(R.string.title_score_activity), false);

        RecyclerView recyclerView = findViewById(R.id.rvScores);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ScoreAdapterRecyclerView scoreAdapterRecyclerView =
                new ScoreAdapterRecyclerView(
                        MenuActivity.store.raitingList(10),
                        this,
                        R.layout.cardview_score);

        recyclerView.setAdapter(scoreAdapterRecyclerView);
    }


    /*----------------------------------------------------------------------------------------------
    Mostrar el Toolbar con diferentes caracteristicas
     */
    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
