package com.radionov.nyreaderspidertest.model.network;

import com.radionov.nyreaderspidertest.model.dto.GetArticlesResponseDto;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit REST api methods
 */

public interface ArticleApi {
    @GET("all.json")
    Observable<GetArticlesResponseDto> getUsers(@Query("api-key") String apiKey);
}
