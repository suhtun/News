package com.sumyat.newsapp.data.remote

import com.sumyat.newsapp.commom.FakeRemoteDataSource
import com.sumyat.newsapp.data.remote.dto.NewsDto

class MockNewsApi: NewsApi {
    override suspend fun getHeadlines(
        countryCode: String,
        pageNumber: Int,
        apiKey: String
    ): NewsDto {
        return FakeRemoteDataSource.headlineFirstData
    }

    override suspend fun searchForNews(searchQuery: String, page: Int, apiKey: String): NewsDto {
        return FakeRemoteDataSource.searchNewsFirstData
    }
}