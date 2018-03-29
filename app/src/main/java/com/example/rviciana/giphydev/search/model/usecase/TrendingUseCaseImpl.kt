package com.example.rviciana.giphydev.search.model.usecase

import com.example.rviciana.giphydev.search.model.SearchRepository
import com.example.rviciana.giphydev.search.model.entities.Data
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

class TrendingUseCaseImpl(private val searchRepository: SearchRepository) : TrendingUseCase {

    private var subscription: Subscription = Subscriptions.empty()

    override fun execute(subscriber: Subscriber<Data>) {
        subscription = buildObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber)
    }

    override fun buildObservable(): Observable<Data> {
        return searchRepository.trendingGif()
    }
}