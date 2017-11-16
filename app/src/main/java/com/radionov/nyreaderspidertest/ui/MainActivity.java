package com.radionov.nyreaderspidertest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.ui.articles.ArticlesFragment;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.active_fragment, new ArticlesFragment())
                    .commit();
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ImageView nyTitle = findViewById(R.id.ny_title);
        Picasso.with(this)
                .load(R.raw.the_new_york_times_logo)
                .into(nyTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
