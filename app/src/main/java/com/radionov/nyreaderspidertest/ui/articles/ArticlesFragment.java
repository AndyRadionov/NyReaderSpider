package com.radionov.nyreaderspidertest.ui.articles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.model.dto.ArticleDto;

import java.util.List;


/**
 * A simple {@link Fragment} subclass for showing list of ny times articles
 */
public class ArticlesFragment extends Fragment implements ArticlesView {


    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void viewArticles(List<ArticleDto> articles) {

    }
}
