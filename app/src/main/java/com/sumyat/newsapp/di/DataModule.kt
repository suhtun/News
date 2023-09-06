package com.sumyat.newsapp.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sumyat.newsapp.data.repository.NewsRemoteMediator
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.local.bookmark.BookmarkDao
import com.sumyat.newsapp.data.remote.NewsApi
import com.sumyat.newsapp.data.repository.NewsRepositoryImpl
import com.sumyat.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi,bookmarkDao: BookmarkDao,articleDao: ArticleDao): NewsRepository = NewsRepositoryImpl(api,bookmarkDao,articleDao)

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideNewsPager(articleDao: ArticleDao, newsApi: NewsApi): Pager<Int, ArticleEntity>{
        return Pager(config = PagingConfig(20),
            remoteMediator = NewsRemoteMediator(articleDao=articleDao,newsApi=newsApi),
            pagingSourceFactory = {
                articleDao.pagingSource()
            })
    }
}