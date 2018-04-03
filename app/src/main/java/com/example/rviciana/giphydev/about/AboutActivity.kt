package com.example.rviciana.giphydev.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.rviciana.giphydev.R
import com.example.rviciana.giphydev.search.view.BaseActivity
import com.example.rviciana.giphydev.utils.GiphyConstants
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.toolbar.*

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initToolbar()
        initAboutLogo()
        setContent()
        setListener()
    }

    override fun initToolbar() {
        toolbar.setTitle(R.string.about_activity_toolbar_title)
        super.initToolbar()
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
        githubUser.text = getString(R.string.about_activity_github_user)
    }

    private fun setListener() {
        githubUser.setOnClickListener{ launchBrowser() }
    }

    private fun launchBrowser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(GiphyConstants.GITHUB)
        startActivity(intent)
    }
}
