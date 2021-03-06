package com.example.rviciana.giphydev.search.di.component

import com.example.rviciana.giphydev.search.di.module.SearchModule
import com.example.rviciana.giphydev.search.view.SearchActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(SearchModule::class))
interface SearchComponent {

    fun inject(activity: SearchActivity)
}