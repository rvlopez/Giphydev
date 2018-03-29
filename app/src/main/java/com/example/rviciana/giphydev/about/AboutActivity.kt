package com.example.rviciana.giphydev.about

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.rviciana.giphydev.R
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.toolbar.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initToolbar()
        initAboutLogo()
        setContent()
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setTitle(R.string.about_activity_toolbar_title)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun initAboutLogo() {
        Glide.with(this)
                .asGif()
                .load(R.raw.labs)
                .into(about_logo)
    }

    private fun setContent() {
        aboutContent.text = getString(R.string.about_activity_description)
        aboutMe.text = getString(R.string.about_activity_me)
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
