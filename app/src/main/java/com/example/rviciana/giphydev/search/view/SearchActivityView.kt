package com.example.rviciana.giphydev.search.view

import com.example.rviciana.giphydev.search.model.entities.Gif

interface SearchActivityView {

    fun showProgress()

    fun hideProgress()

    fun showNoResults()

    fun hideNoResults()

    fun showError()

    fun hideError()

    fun resultsNotFound()

    fun showGifs(dataList: MutableList<Gif>)
}