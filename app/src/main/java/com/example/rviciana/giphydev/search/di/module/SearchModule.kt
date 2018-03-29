package com.example.rviciana.giphydev.search.di.module

import com.example.rviciana.giphydev.search.model.SearchApi
import com.example.rviciana.giphydev.search.model.SearchRepository
import com.example.rviciana.giphydev.search.model.SearchRepositoryImpl
import com.example.rviciana.giphydev.search.model.usecase.*
import com.example.rviciana.giphydev.search.presenter.SearchPresenter
import com.example.rviciana.giphydev.search.presenter.SearchPresenterImpl
import com.example.rviciana.giphydev.search.view.SearchActivity
import com.example.rviciana.giphydev.utils.GiphyConstants
import com.example.rviciana.giphydev.utils.ServiceFactory
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    fun provideSearchApi(): SearchApi {
        return ServiceFactory.createRetrofitService(GiphyConstants.HOST)
    }

    @Provides
    fun provideSearchRepository(searchApi: SearchApi): SearchRepository {
        return SearchRepositoryImpl(searchApi)
    }

    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepository): SearchUseCase {
        return SearchUseCaseImpl(searchRepository)
    }

    @Provides
    fun provideTrendingUseCase(searchRepository: SearchRepository): TrendingUseCase {
        return TrendingUseCaseImpl(searchRepository)
    }

    @Provides
    fun provideRandomUseCase(searchRepository: SearchRepository): RandomUseCase {
        return RandomUseCaseImpl(searchRepository)
    }

    @Provides
    fun provideSearchPresenter(searchUseCase: SearchUseCase,
                               trendingUseCase: TrendingUseCase,
                               randomUseCase: RandomUseCase): SearchPresenter {
        return SearchPresenterImpl(searchUseCase, trendingUseCase, randomUseCase)
    }
}