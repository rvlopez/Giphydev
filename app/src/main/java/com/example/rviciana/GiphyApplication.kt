package com.example.rviciana

import android.app.Application
import com.example.rviciana.giphydev.di.component.ApplicationComponent
import com.example.rviciana.giphydev.di.component.DaggerApplicationComponent
import com.example.rviciana.giphydev.di.module.ApplicationModule

class GiphyApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        component.inject(this)
    }
}