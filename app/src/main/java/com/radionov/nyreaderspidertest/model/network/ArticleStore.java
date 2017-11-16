package com.radionov.nyreaderspidertest.model.network;

import com.radionov.nyreaderspidertest.model.dto.ArticleDto;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface for manipulate Articles data
 */

public interface ArticleStore {
    /**
     * Get Articles from REST api
     */
    Observable<List<ArticleDto>> getArticles();
}
