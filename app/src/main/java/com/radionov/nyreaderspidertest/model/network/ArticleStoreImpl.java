package com.radionov.nyreaderspidertest.model.network;

import com.radionov.nyreaderspidertest.app.App;
import com.radionov.nyreaderspidertest.app.AppPreferences;
import com.radionov.nyreaderspidertest.model.dto.ArticleDto;
import com.radionov.nyreaderspidertest.model.dto.GetArticlesResponseDto;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Network implementation for {@link ArticleStore}
 */

public class ArticleStoreImpl implements ArticleStore {
    private ArticleApi articleApi;

    public ArticleStoreImpl() {
        articleApi = App.getApi();
    }

    @Override
    public Observable<List<ArticleDto>> getArticles() {
        return articleApi.getUsers(AppPreferences.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(GetArticlesResponseDto::getResults);
    }
}

