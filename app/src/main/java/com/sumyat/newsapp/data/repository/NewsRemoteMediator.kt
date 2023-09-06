package com.sumyat.newsapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.sumyat.newsapp.data.local.article.ArticleDao
import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.mappers.toArticleEntity
import com.sumyat.newsapp.data.remote.NewsApi
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(private val articleDao: ArticleDao, private val newsApi: NewsApi) :
    RemoteMediator<Int, ArticleEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id ?: (1 / state.config.pageSize)) + 1
                    }
                }
            }

            val news = newsApi.getHeadlines(
                pageNumber = loadKey,
            )

            if (loadType == LoadType.REFRESH) {
                articleDao.clearAll()
            }
            val articleEntities = news.articles.map { it.toArticleEntity() }
                .filter { !(it.title.isNullOrEmpty() && it.urlToImage.isNullOrBlank()) }
            articleDao.upsertAll(articleEntities)

            MediatorResult.Success(
                endOfPaginationReached = news.articles.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}