package com.sumyat.newsapp.di

import android.content.Context
import androidx.room.Room
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.local.NewsDatabase
import com.sumyat.newsapp.data.local.bookmark.BookmarkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "newsapp.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(database: NewsDatabase): ArticleDao {
        return database.articleDao()
    }

    @Provides
    @Singleton
    fun provideBookmarkEntity(database: NewsDatabase): BookmarkDao{
        return database.bookmarkDao()
    }

}