package com.sumyat.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.local.bookmark.BookmarkDao
import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity

@Database(entities = [ArticleEntity::class, BookmarkEntity::class], version = 2)
abstract class NewsDatabase : RoomDatabase(){
    abstract fun articleDao(): ArticleDao
    abstract fun bookmarkDao(): BookmarkDao
}