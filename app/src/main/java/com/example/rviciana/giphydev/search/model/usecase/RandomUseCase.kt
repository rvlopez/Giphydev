package com.example.rviciana.giphydev.search.model.usecase

import com.example.rviciana.giphydev.search.model.entities.Data
import rx.Observable
import rx.Subscriber

interface RandomUseCase {

    fun execute(subscriber: Subscriber<Data>)

    fun buildObservable(): Observable<Data>
}