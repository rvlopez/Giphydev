package com.example.rviciana.giphydev.search.model.usecase

import com.example.rviciana.giphydev.search.model.SearchRepository
import com.example.rviciana.giphydev.search.model.entities.Data
import rx.Observable
import rx.Subscription
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(private val searchRepository: SearchRepository) : SearchUseCase {

    private var subscription: Subscription = Subscriptions.empty()

    override fun execute(query: String, subscriber: Subscriber<Data>) {
        subscription = buildObservable(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber)
    }

    override fun buildObservable(query: String): Observable<Data> {
        return searchRepository.searchGif(query)
    }
}