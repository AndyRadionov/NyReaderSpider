package com.radionov.nyreaderspidertest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.ui.articles.ArticlesFragment;

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
    }
}
