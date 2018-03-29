package com.example.rviciana.giphydev.search.presenter

import com.example.rviciana.giphydev.search.view.SearchActivityView

interface SearchPresenter {

    fun setView(searchActivityView: SearchActivityView)

    fun searchGif(query: String)

    fun trendingGif()

    fun randomGif()
}