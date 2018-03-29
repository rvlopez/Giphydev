package com.example.rviciana.giphydev.search.view

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.example.rviciana.GiphyApplication
import com.example.rviciana.giphydev.R
import com.example.rviciana.giphydev.about.AboutActivity
import com.example.rviciana.giphydev.search.di.module.SearchModule
import com.example.rviciana.giphydev.search.model.entities.Data
import com.example.rviciana.giphydev.search.model.entities.Gif
import com.example.rviciana.giphydev.search.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.error_layout.*
import kotlinx.android.synthetic.main.horizontal_progress_bar.*
import kotlinx.android.synthetic.main.no_results_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchActivityView, View.OnClickListener {

    @Inject lateinit var searchPresenter: SearchPresenter

    lateinit var search: String

    private val Activity.app: GiphyApplication get() = application as GiphyApplication
    private val component by lazy { app.component.plus(SearchModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        initInjector()
        setListeners()
        initToolbar()
        initSearchView()
        initPresenter()
        initHeader()
    }

    private fun initInjector() {
        component.inject(this)
    }

    private fun setListeners() {
        searchIcon.setOnClickListener(this)
    }

    private fun initToolbar() {
        toolbar.setTitle(R.string.main_activity_toolbar_title)
        setSupportActionBar(toolbar)
    }

    private fun initSearchView() {
        search = getString(R.string.header_trending_now)
        Glide.with(this).asGif().load(R.raw.search_animation_go).into(searchIcon)
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                search = query!!
                searchPresenter.searchGif(query)
                gifRecyclerView.adapter.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search = newText!!
                return false
            }
        })
    }

    private fun initPresenter() {
        searchPresenter.setView(this)
        searchPresenter.trendingGif()
    }

    private fun initHeader() {
        setRecyclerViewHeader(getString(R.string.header_trending_now))
    }

    override fun onClick(view: View?) {
        searchPresenter.searchGif(search)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showNoResults() {
        noResultsLayout.visibility = View.VISIBLE
    }

    override fun hideNoResults() {
        noResultsLayout.visibility = View.GONE
    }

    override fun showError() {
        errorLayout.visibility = View.VISIBLE
        Glide.with(this).asGif().load(R.raw.labs).into(errorImage)
    }

    override fun hideError() {
        errorLayout.visibility = View.GONE
    }

    override fun resultsNotFound() {
        noResultsMessage.text = String.format(getString(R.string.no_results_found), search)
    }

    override fun showGifs(dataList: MutableList<Gif>) {
        gifRecyclerHeader.text = search
        gifResultsValue.visibility = View.VISIBLE
        gifResultsValue.text = String.format(getString(R.string.gif_results_value), dataList.size)
        initRecyclerView(dataList)
    }

    private fun initRecyclerView(dataList: MutableList<Gif>) {
        gifRecyclerView.layoutManager = LinearLayoutManager(this)
        gifRecyclerView.adapter = SearchAdapter(dataList)
    }

    private fun setRecyclerViewHeader(header: String) {
        gifRecyclerHeader.text = header.toUpperCase()
    }

    private fun openPopUp() {
        val builder = AlertDialog.Builder(this).create()
        builder.setTitle(R.string.filter_dialog_title)
        builder.setMessage(getString(R.string.filter_dialog_message))

        with(builder) {
            // TODO: PopUp type search selector
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_search_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id: Int = item!!.itemId

        when (id) {
            R.id.filter -> {
                openPopUp()
            }
            R.id.info -> {
                startActivity(Intent(this, AboutActivity::class.java))
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
