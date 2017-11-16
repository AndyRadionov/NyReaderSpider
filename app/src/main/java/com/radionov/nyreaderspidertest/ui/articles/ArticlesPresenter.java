package com.radionov.nyreaderspidertest.ui.articles;

import com.radionov.nyreaderspidertest.model.dto.ArticleDto;
import com.radionov.nyreaderspidertest.model.network.ArticleStore;
import com.radionov.nyreaderspidertest.model.network.ArticleStoreImpl;

import java.util.List;

import io.reactivex.Observable;

/**
 * Articles Presenter
 */

public class ArticlesPresenter {
    private ArticleStore articleStore;
    private ArticlesView articlesView;

    public ArticlesPresenter(ArticlesView articlesView) {
        this.articleStore = new ArticleStoreImpl();
        this.articlesView = articlesView;
    }

    public void loadArticles() {
        Observable<List<ArticleDto>> articlesObservable = articleStore.getArticles();
        articlesObservable.subscribe(articles -> articlesView.viewArticles(articles));
    }
}
