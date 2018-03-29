package com.example.rviciana.giphydev.search.model

import com.example.rviciana.giphydev.search.model.entities.Data
import com.example.rviciana.giphydev.utils.GiphyConstants
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface SearchApi {

    companion object {
        const val API_KEY = "api_key"
        const val QUERY = "q"
    }

    @GET(GiphyConstants.HOST + GiphyConstants.SEARCH_URL)
    fun searchGif(@Query(API_KEY) api_key: String, @Query(QUERY) query: String): Observable<Data>

    @GET(GiphyConstants.HOST + GiphyConstants.TRENDING_URL)
    fun trending(@Query(API_KEY) api_key: String): Observable<Data>

    @GET(GiphyConstants.HOST + GiphyConstants.RANDOM_URL)
    fun random(@Query(API_KEY) api_key: String): Observable<Data>
}