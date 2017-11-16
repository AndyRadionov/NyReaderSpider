package com.radionov.nyreaderspidertest.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.radionov.nyreaderspidertest.model.network.ArticleApi;
import com.radionov.nyreaderspidertest.model.network.ArticleStore;
import com.radionov.nyreaderspidertest.model.network.ArticleStoreImpl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application class
 */

public class App extends Application {
    private static ArticleApi articleApi;
    private static ArticleStore articleStore;

    @Override
    public void onCreate() {
        super.onCreate();

        articleApi = createApi();
        articleStore = new ArticleStoreImpl();
    }

    public static ArticleApi getApi() {
        return articleApi;
    }

    public static ArticleStore getArticleStore() {
        return articleStore;
    }

    /**
     * Check if Internet is Available on device
     *
     * @param context of application
     * @return internet status
     */
    public static boolean isInternetAvailable(Context context) {
        Log.d("UTILS", "isInternetAvailable");
        ConnectivityManager mConMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return mConMgr.getActiveNetworkInfo() != null
                && mConMgr.getActiveNetworkInfo().isAvailable()
                && mConMgr.getActiveNetworkInfo().isConnected();
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
