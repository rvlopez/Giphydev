package com.example.rviciana.giphydev.search.view

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.rviciana.giphydev.R
import kotlinx.android.synthetic.main.toolbar.*

open class BaseActivity: AppCompatActivity() {

    open fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.arrow_left)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        when (id) {
            android.R.id.home -> { onBackPressed() }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right)
    }
}