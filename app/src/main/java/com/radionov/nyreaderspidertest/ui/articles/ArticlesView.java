package com.radionov.nyreaderspidertest.ui.articles;

import com.radionov.nyreaderspidertest.model.dto.ArticleDto;

import java.util.List;

/**
 * Articles View
 */

public interface ArticlesView {
    void viewArticles(List<ArticleDto> articles);
}
