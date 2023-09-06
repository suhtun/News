package com.sumyat.newsapp.presentation.feature.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumyat.newsapp.commom.Result
import com.sumyat.newsapp.commom.asResult
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.domain.usecase.GetBookmarksUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(private val getBookmarksUserCase: GetBookmarksUserCase) :
    ViewModel() {

    private val _bookmarksUiState = MutableStateFlow(BookmarksUiState())
    val bookmarksUiState = _bookmarksUiState.asStateFlow()

    init {
        viewModelScope.launch {
            getBookmarksUserCase.invoke().asResult().collect { result ->
                _bookmarksUiState.update {
                    when (result) {
                        is Result.Loading -> {
                            BookmarksUiState(isLoading = true)
                        }

                        is Result.Success -> {
                            BookmarksUiState(false, result.data)
                        }

                        is Result.Error -> {
                            BookmarksUiState(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}

data class BookmarksUiState(
    val isLoading: Boolean = false,
    val bookmarks: List<Article>? = emptyList(),
)