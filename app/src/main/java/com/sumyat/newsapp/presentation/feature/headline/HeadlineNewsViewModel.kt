package com.sumyat.newsapp.presentation.feature.headline

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.mappers.toArticle
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.usecase.SaveBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlineNewsViewModel @Inject constructor(pager: Pager<Int, ArticleEntity>) : ViewModel() {

    val headlinenewsPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toArticle() }.filter { it.urlToImage.isNotEmpty() }
        }
        .cachedIn(viewModelScope)

}