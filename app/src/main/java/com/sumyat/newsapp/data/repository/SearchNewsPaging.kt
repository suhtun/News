package com.sumyat.newsapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sumyat.newsapp.data.mappers.toArticle
import com.sumyat.newsapp.data.remote.NewsApi
import com.sumyat.newsapp.data.remote.dto.NewsDto
import com.sumyat.newsapp.domain.model.Article

class SearchNewsPaging(private val searchQuery: String, private val newsApi: NewsApi) :
    PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val response = newsApi.searchForNews(searchQuery = searchQuery, page = page)
            LoadResult.Page(
                data = response.articles.map { it.toArticle() },
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.articles.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}