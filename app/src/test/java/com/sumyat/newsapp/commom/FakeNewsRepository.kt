package com.sumyat.newsapp.commom

import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNewsRepository: NewsRepository {

    private val articles = mutableListOf<Article>()
    override suspend fun searchArticle(id: Int): Article? {
        return articles.find { it.id == id }
    }

    override suspend fun searchForNews(searchQuery: String, pageNumber: Int): List<Article> {
        return articles
    }

    override suspend fun saveBookmark(article: Article) {
        articles.add(article)
    }

    override suspend fun getBookmarks(): Flow<List<Article>> {
        return flow { emit(articles) }
    }

}