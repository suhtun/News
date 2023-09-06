package com.sumyat.newsapp.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.local.bookmark.BookmarkDao
import com.sumyat.newsapp.data.mappers.toArticle
import com.sumyat.newsapp.data.mappers.toArticles
import com.sumyat.newsapp.data.mappers.toBookmarkEntity
import com.sumyat.newsapp.data.remote.NewsApi
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val bookmarkDao: BookmarkDao,
    private val articleDao: ArticleDao
) : NewsRepository {

    override suspend fun searchArticle(id: Int): Article? {
        return articleDao.searchArticle(id)
    }

    override suspend fun searchForNews(searchQuery: String, page: Int): List<Article> {
        return newsApi.searchForNews(
            searchQuery = searchQuery,
            page = page
        ).articles.map { it.toArticle() }
    }

    override suspend fun saveBookmark(article: Article) {
        bookmarkDao.insetBookmark(article.toBookmarkEntity())
    }

    override suspend fun getBookmarks(): Flow<List<Article>> {
        return bookmarkDao.getBookmarks().map { toArticles(it) }
    }
}