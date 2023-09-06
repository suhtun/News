package com.sumyat.newsapp.di

import com.sumyat.newsapp.data.remote.NewsApi
import com.sumyat.newsapp.data.remote.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideNewsApi(): NewsApi{
        return RetrofitInstance.newsApi
    }
}