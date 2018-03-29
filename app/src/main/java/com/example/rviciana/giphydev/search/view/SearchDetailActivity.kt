package com.example.rviciana.giphydev.search.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.rviciana.giphydev.R
import kotlinx.android.synthetic.main.toolbar.*

class SearchDetailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail)

        initToolbar()
    }

    override fun initToolbar() {
        toolbar.setTitle(R.string.detail_activity_toolbar_title)
        super.initToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_search_detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        when (id) {
            R.id.external -> {  }
        }

        return super.onOptionsItemSelected(item)
    }
}