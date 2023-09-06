package com.sumyat.newsapp.domain.usecase

import android.util.Log
import com.sumyat.newsapp.domain.exceptions.NewsAppException
import com.sumyat.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveBookmarkUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(id: Int) {
        val article = newsRepository.searchArticle(id)
        article?.let { newsRepository.saveBookmark(it) } ?: throw NewsAppException.InvalidDataException
    }
}