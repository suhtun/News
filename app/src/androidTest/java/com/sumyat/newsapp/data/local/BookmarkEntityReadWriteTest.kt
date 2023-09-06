package com.sumyat.newsapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sumyat.newsapp.common.MockData
import com.sumyat.newsapp.data.local.bookmark.BookmarkDao
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class BookmarkEntityReadWriteTest {

    private lateinit var db: NewsDatabase
    private lateinit var bookmarkDao: BookmarkDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NewsDatabase::class.java
        ).build()
        bookmarkDao = db.bookmarkDao()
    }

    @Test
    fun insertBookmark_getBookmarks() = runTest{
        val mockBookmark= MockData.createBookEntity()
        bookmarkDao.insetBookmark(mockBookmark)
        val localBookmark = bookmarkDao.getBookmarks().first()[0]
        assertEquals(mockBookmark.sourceName, localBookmark.sourceName)
        assertEquals(mockBookmark.title, localBookmark.title)
        assertEquals(mockBookmark.publishedAt, localBookmark.publishedAt)
        assertEquals(mockBookmark.url, localBookmark.url)
        assertEquals(mockBookmark.urlToImage, localBookmark.urlToImage)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}