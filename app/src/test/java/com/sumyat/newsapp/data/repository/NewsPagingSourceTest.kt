package com.sumyat.newsapp.data.repository

import androidx.paging.PagingSource
import com.sumyat.newsapp.commom.FakeRemoteDataSource
import com.sumyat.newsapp.data.mappers.toArticle
import com.sumyat.newsapp.data.remote.MockNewsApi
import kotlinx.coroutines.test.runTest
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NewsPagingSourceTest {

    private lateinit var fakeNewsApi: MockNewsApi

    @Before
    fun createDb() {
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
}