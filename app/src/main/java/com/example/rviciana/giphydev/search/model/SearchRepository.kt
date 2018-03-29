package com.example.rviciana.giphydev.search.model

import com.example.rviciana.giphydev.search.model.entities.Data
import rx.Observable

interface SearchRepository {

    fun searchGif(query: String): Observable<Data>

    fun trendingGif(): Observable<Data>

    fun randomGif(): Observable<Data>

}