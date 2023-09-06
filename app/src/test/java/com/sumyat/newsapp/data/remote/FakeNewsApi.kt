package com.sumyat.newsapp.data.remote

import com.sumyat.newsapp.commom.Dispatcher
import com.sumyat.newsapp.commom.FakeRemoteDataSource
import com.sumyat.newsapp.commom.NewsDispatchers
import com.sumyat.newsapp.data.remote.dto.NewsDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class FakeNewsApi(
    @Dispatcher(NewsDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json
) : NewsApi {
    override suspend fun getHeadlines(
        countryCode: String,
        pageNumber: Int,
        apiKey: String
    ): NewsDto {
        return withContext(ioDispatcher) {
            networkJson.decodeFromString(FakeRemoteDataSource.headlinesResponse) as NewsDto
        }
    }

    override suspend fun searchForNews(searchQuery: String, page: Int, apiKey: String): NewsDto {
        return withContext(ioDispatcher) {
            networkJson.decodeFromString(FakeRemoteDataSource.searchNewsResponse) as NewsDto
        }
    }

}