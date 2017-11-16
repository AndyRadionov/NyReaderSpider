package com.radionov.nyreaderspidertest.ui.articles;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.model.dto.ArticleDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass for showing list of ny times articles
 */
public class ArticlesFragment extends Fragment implements ArticlesView {
    private Unbinder unbinder;
    private ArticlesPresenter articlesPresenter;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articlesPresenter = new ArticlesPresenter(this);

        articlesPresenter.loadArticles();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void viewArticles(List<ArticleDto> articles) {
        ArticleAdapter articleAdapter = new ArticleAdapter(articles);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),
                2, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
