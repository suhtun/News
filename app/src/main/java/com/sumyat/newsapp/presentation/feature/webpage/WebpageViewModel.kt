package com.sumyat.newsapp.presentation.feature.webpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumyat.newsapp.domain.usecase.SaveBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebpageViewModel @Inject constructor(private val saveBookmarkUseCase: SaveBookmarkUseCase) :
    ViewModel() {
    private val _webpageUiState = MutableStateFlow<WebpageUiState>(WebpageUiState.None)
    val webpageUiState = _webpageUiState.asStateFlow()

    fun bookmarkArticle(id: Int?) {
        viewModelScope.launch {
            try {
                if (id == null) {
                    _webpageUiState.emit(WebpageUiState.FailureToSaveArticle("empty Article's data"))
                } else {
                    saveBookmarkUseCase.invoke(id)
                    _webpageUiState.emit(WebpageUiState.SavedArticle)
                }
            } catch (throwable: Throwable) {
                _webpageUiState.emit(WebpageUiState.FailureToSaveArticle(throwable.localizedMessage))
            }
        }
    }
}

sealed interface WebpageUiState {
    object None : WebpageUiState
    object SavedArticle : WebpageUiState
    data class FailureToSaveArticle(val error: String) : WebpageUiState
}