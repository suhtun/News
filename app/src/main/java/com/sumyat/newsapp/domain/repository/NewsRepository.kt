package com.sumyat.newsapp.domain.repository

import androidx.paging.Pager
import com.sumyat.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun searchArticle(id:Int): Article?

    suspend fun searchForNews(searchQuery: String, pageNumber: Int): List<Article>

    suspend fun saveBookmark(article: Article)

    suspend fun getBookmarks(): Flow<List<Article>>
}