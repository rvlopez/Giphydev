package com.example.rviciana.giphydev.di.module

import com.example.rviciana.GiphyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: GiphyApplication) {

    @Provides @Singleton
    fun provideApplication() = application


}