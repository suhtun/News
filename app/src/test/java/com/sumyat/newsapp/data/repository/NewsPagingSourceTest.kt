package com.sumyat.newsapp.data.repository

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.map
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.sumyat.newsapp.commom.FakeRemoteDataSource
import com.sumyat.newsapp.data.local.NewsDatabase
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.mappers.toArticle
import com.sumyat.newsapp.data.remote.MockNewsApi
import kotlinx.coroutines.test.runTest
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.map
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NewsPagingSourceTest {

    private lateinit var fakeNewsApi: MockNewsApi
    private lateinit var db: NewsDatabase
    private lateinit var articleDao: ArticleDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NewsDatabase::class.java
        ).build()
        articleDao = db.articleDao()
        fakeNewsApi = MockNewsApi()
    }

    @Test
    fun `newsPagingSource`() = runTest {
        val searchNewsPaging = SearchNewsPaging("sport", fakeNewsApi)
        val mockArticles = FakeRemoteDataSource.searchNewsFirstData.articles.map { it.toArticle() }
        assertEquals(
            PagingSource.LoadResult.Page(
                data = listOf(mockArticles[0], mockArticles[1]),
                prevKey = null,
                nextKey = 2
            ),
            searchNewsPaging.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            ),
        )
    }

//    @OptIn(ExperimentalPagingApi::class)
//    @Test
//    fun `headlinePagingSource`() = runTest {
//        val newsPaging = Pager(config = PagingConfig(20),
//            remoteMediator = NewsRemoteMediator(articleDao=articleDao,newsApi=fakeNewsApi),
//            pagingSourceFactory = {
//                articleDao.pagingSource()
//            }).flow.map { pagingData ->
//            pagingData
//        }
//
//        val mockArticles = FakeRemoteDataSource.searchNewsFirstData.articles.map { it.toArticle() }
//        assertEquals(
//            mockArticles,
//            newsPaging,
//        )
//    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}