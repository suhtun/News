package com.sumyat.newsapp.domain.usecase

import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarksUserCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend fun invoke(): Flow<List<Article>> {
        return newsRepository.getBookmarks()
    }
}