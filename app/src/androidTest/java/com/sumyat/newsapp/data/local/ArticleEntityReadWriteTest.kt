package com.sumyat.newsapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sumyat.newsapp.common.MockData
import com.sumyat.newsapp.data.local.article.ArticleDao
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ArticleEntityReadWriteTest {

    private lateinit var db: NewsDatabase
    private lateinit var articleDao: ArticleDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NewsDatabase::class.java
        ).build()
        articleDao = db.articleDao()
    }

    @Test
    fun upsertAll_searchById() = runTest{
        val mockArticle = MockData.createArticleEntity()
        articleDao.upsertAll(mutableListOf(mockArticle))
        val localArticle = articleDao.searchArticle(806)
        assertEquals(mockArticle.sourceName, localArticle.sourceName)
        assertEquals(mockArticle.title, localArticle.title)
        assertEquals(mockArticle.publishedAt, localArticle.publishedAt)
        assertEquals(mockArticle.url, localArticle.url)
        assertEquals(mockArticle.urlToImage, localArticle.urlToImage)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}