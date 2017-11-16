package com.radionov.nyreaderspidertest.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * DTO for deserialization all articles from JSON
 */

public class GetArticlesResponseDto {
    @Expose
    private List<ArticleDto> results;

    public List<ArticleDto> getResults() {
        return results;
    }

    public void setResults(List<ArticleDto> results) {
        this.results = results;
    }
}
