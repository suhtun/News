package com.sumyat.newsapp.presentation.feature.searchnews

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.usecase.SearchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(private val searchNewsUseCase: SearchNewsUseCase) :
    ViewModel() {

    private val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery: StateFlow<String?> = _searchQuery

    fun searchNews(): Flow<PagingData<Article>> {
        return _searchQuery.value?.let {
            searchNewsUseCase.invoke(searchQuery = searchQuery.value!!).cachedIn(viewModelScope)
        }?: emptyFlow()
    }

    fun updateSearchQuery(searchQuery: String) {
        _searchQuery.update { searchQuery }
    }
}