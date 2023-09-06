package com.sumyat.newsapp.data

import com.sumyat.newsapp.commom.FakeRemoteDataSource
import com.sumyat.newsapp.data.remote.FakeNewsApi
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class NewsRepositoryImplTest {

    private lateinit var fakeNewsApi: FakeNewsApi

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        fakeNewsApi = FakeNewsApi(ioDispatcher = testDispatcher,
            networkJson = Json { ignoreUnknownKeys = true })
    }

    @Test
    fun `search New by searchQuery, correct response`() = runTest(testDispatcher) {
        val expectedResponse = FakeRemoteDataSource.searchNewsFirstData
        val actualResponse = fakeNewsApi.searchForNews("sport")
        assertEquals(
            expectedResponse.articles.first(),
            actualResponse.articles.first()
        )
    }

    @Test
    fun `headlines API, correct response`() = runTest(testDispatcher) {
        val expectedResponse = FakeRemoteDataSource.headlineFirstData
        val actualResponse = fakeNewsApi.getHeadlines()
        assertEquals(
            expectedResponse.articles.first(),
            actualResponse.articles.first()
        )

    }
}