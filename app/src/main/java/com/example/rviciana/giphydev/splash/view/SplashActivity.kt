package com.example.rviciana.giphydev.splash.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rviciana.giphydev.R
import com.example.rviciana.giphydev.search.view.SearchActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initSplashLogo()
        scheduleNewActivity()
    }

    private fun initSplashLogo() {
        Glide.with(this)
                .asGif()
                .load(R.raw.dev_logo)
                .into(splash_logo)
    }

    private fun initApplication() {
        startActivity(Intent(this, SearchActivity::class.java))
        finish()
    }

    private fun scheduleNewActivity() {
        val startActivity = object: TimerTask() {
            override fun run() {
                initApplication()
            }
        }
        Timer().schedule(startActivity, 7000)
    }
}