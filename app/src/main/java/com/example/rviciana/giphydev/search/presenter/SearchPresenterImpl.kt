package com.example.rviciana.giphydev.search.presenter

import com.example.rviciana.giphydev.search.model.entities.Data
import com.example.rviciana.giphydev.search.model.entities.Gif
import com.example.rviciana.giphydev.search.model.usecase.RandomUseCase
import com.example.rviciana.giphydev.search.model.usecase.SearchUseCase
import com.example.rviciana.giphydev.search.model.usecase.TrendingUseCase
import com.example.rviciana.giphydev.search.view.SearchActivityView
import rx.Subscriber
import javax.inject.Inject

class SearchPresenterImpl @Inject constructor(private val searchUseCase: SearchUseCase,
                                              private val trendingUseCase: TrendingUseCase,
                                              private val randomUseCase: RandomUseCase) : SearchPresenter {

    var searchActivityView: SearchActivityView? = null

    override fun setView(searchActivityView: SearchActivityView) {
        this.searchActivityView = searchActivityView
    }

    override fun searchGif(query: String) {
        searchActivityView!!.showProgress()

        searchUseCase.execute(query, object: Subscriber<Data>() {

            val gifList = mutableListOf<Gif>()

            override fun onCompleted() {
                searchActivityView!!.hideProgress()
                searchActivityView!!.hideError()

                if (!gifList.isEmpty()) {
                    searchActivityView!!.hideNoResults()
                    searchActivityView!!.showGifs(gifList)
                } else {
                    searchActivityView!!.showNoResults()
                    searchActivityView!!.resultsNotFound()
                }
            }

            override fun onError(throwable: Throwable?) {
                searchActivityView!!.hideProgress()
                searchActivityView!!.showError()
            }

            override fun onNext(data: Data?) {
                gifList.addAll(data!!.dataList)
            }
        })
    }

    override fun trendingGif() {
        searchActivityView!!.showProgress()

        trendingUseCase.execute(object: Subscriber<Data>() {

            val gifList = mutableListOf<Gif>()

            override fun onCompleted() {
                searchActivityView!!.hideProgress()
                searchActivityView!!.hideError()

                if (!gifList.isEmpty()) {
                    searchActivityView!!.hideNoResults()
                    searchActivityView!!.showGifs(gifList)
                } else {
                    searchActivityView!!.showNoResults()
                    searchActivityView!!.resultsNotFound()
                }
            }

            override fun onError(throwable: Throwable?) {
                searchActivityView!!.hideProgress()
                searchActivityView!!.showError()
            }

            override fun onNext(data: Data?) {
                gifList.addAll(data!!.dataList)
            }
        })
    }

    override fun randomGif() {
        searchActivityView!!.showProgress()

        randomUseCase.execute(object: Subscriber<Data>() {

            val gifList = mutableListOf<Gif>()

            override fun onCompleted() {
                searchActivityView!!.hideProgress()
                searchActivityView!!.hideError()

                if (!gifList.isEmpty()) {
                    searchActivityView!!.hideNoResults()
                    searchActivityView!!.showGifs(gifList)
                } else {
                    searchActivityView!!.showNoResults()
                    searchActivityView!!.resultsNotFound()
                }
            }

            override fun onError(throwable: Throwable?) {
                searchActivityView!!.hideProgress()
                searchActivityView!!.showError()
            }

            override fun onNext(data: Data?) {
                gifList.addAll(data!!.dataList)
            }
        })
    }
}