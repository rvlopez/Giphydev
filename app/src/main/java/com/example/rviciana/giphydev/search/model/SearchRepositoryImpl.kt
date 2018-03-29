package com.example.rviciana.giphydev.search.model

import com.example.rviciana.giphydev.search.model.entities.Data
import com.example.rviciana.giphydev.utils.GiphyConstants
import rx.Observable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchApi: SearchApi) : SearchRepository {

    override fun searchGif(query: String): Observable<Data> {
        return searchApi.searchGif(GiphyConstants.PUBLIC_KEY, query)
    }

    override fun trendingGif(): Observable<Data> {
        return searchApi.trending(GiphyConstants.PUBLIC_KEY)
    }

    override fun randomGif(): Observable<Data> {
        return searchApi.random(GiphyConstants.PUBLIC_KEY)
    }
}
