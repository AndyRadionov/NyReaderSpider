package com.radionov.nyreaderspidertest.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.radionov.nyreaderspidertest.model.network.ArticleApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application class
 */

public class App extends Application {
    private static ArticleApi articleApi;

    @Override
    public void onCreate() {
        super.onCreate();

        articleApi = createApi();
    }

    public static ArticleApi getApi() {
        return articleApi;
    }

    private static ArticleApi createApi() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ")
                .create();

        return new Retrofit.Builder()
                .baseUrl(AppPreferences.ARTICLES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ArticleApi.class);
    }
}
