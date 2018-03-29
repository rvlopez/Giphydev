package com.example.rviciana.giphydev.di.component

import com.example.rviciana.GiphyApplication
import com.example.rviciana.giphydev.di.module.ApplicationModule
import com.example.rviciana.giphydev.search.di.component.SearchComponent
import com.example.rviciana.giphydev.search.di.module.SearchModule
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: GiphyApplication)

    fun plus(searchModule: SearchModule): SearchComponent

}