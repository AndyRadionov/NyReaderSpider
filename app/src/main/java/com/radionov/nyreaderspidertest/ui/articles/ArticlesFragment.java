package com.radionov.nyreaderspidertest.ui.articles;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.app.App;
import com.radionov.nyreaderspidertest.model.dto.ArticleDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass for showing list of ny times articles
 */
public class ArticlesFragment extends Fragment implements ArticlesView,
        ArticleAdapter.OnItemClickListener {
    private static final int PORTRAIT_ORIENTATION = 1;
    private static final int PORTRAIT_COLUMNS = 2;
    private static final int LANDSCAPE_COLUMNS = 3;

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
        setHasOptionsMenu(true);
        articlesPresenter = new ArticlesPresenter(this);

        loadArticles();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void viewArticles(List<ArticleDto> articles) {
        ArticleAdapter articleAdapter = new ArticleAdapter(articles, this);
        recyclerView.setAdapter(articleAdapter);

        int orientation = getResources().getConfiguration().orientation;
        int spanCount = orientation == PORTRAIT_ORIENTATION ? PORTRAIT_COLUMNS : LANDSCAPE_COLUMNS;
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(spanCount, PORTRAIT_ORIENTATION);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void loadArticles() {
        if (App.isInternetAvailable(getActivity())) {
            articlesPresenter.loadArticles();
        } else {
            Toast.makeText(getActivity(), "No Internet connection!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            articlesPresenter.loadArticles();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(String articleUrl) {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl));
        startActivity(intent);
    }
}
