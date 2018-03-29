package com.example.rviciana.giphydev.search.model.usecase

import com.example.rviciana.giphydev.search.model.entities.Data
import rx.Observable
import rx.Subscriber

interface SearchUseCase {

    fun execute(query: String, subscriber: Subscriber<Data>)

    fun buildObservable(query: String): Observable<Data>
}