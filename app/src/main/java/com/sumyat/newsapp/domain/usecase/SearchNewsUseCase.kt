package com.sumyat.newsapp.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sumyat.newsapp.data.remote.NewsApi
import com.sumyat.newsapp.data.repository.SearchNewsPaging
import com.sumyat.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(private val newsApi: NewsApi) {
    operator fun invoke(searchQuery: String): Flow<PagingData<Article>> {
        return Pager(config = PagingConfig(20),
            pagingSourceFactory = {
                SearchNewsPaging(searchQuery, newsApi)
            }).flow
    }
}