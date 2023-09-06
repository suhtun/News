package com.sumyat.newsapp.presentation.feature.bookmark

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumyat.newsapp.R
import com.sumyat.newsapp.presentation.commom.ArticleHorizontalItem

@Composable
fun BookmarksRoute(
    navigateToWebView: (id: Int?, url: String) -> Unit,
    viewModel: BookmarksViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val bookmarksUiState by viewModel.bookmarksUiState.collectAsState()
    BookmarkScreen(bookmarksUiState = bookmarksUiState, navigateToWebView={ id,url ->navigateToWebView(id,url)}, modifier)
}

@Composable
fun BookmarkScreen(bookmarksUiState: BookmarksUiState,navigateToWebView: (id: Int?, url: String) -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        if (bookmarksUiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            if (bookmarksUiState.bookmarks?.isEmpty() == true) {
                Text(
                    text = stringResource(id = R.string.empty_bookmark),
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 20.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    bookmarksUiState.bookmarks?.let {
                        items(it.size) { position ->
                            val bookmark = bookmarksUiState.bookmarks[position]
                            if (bookmark != null) {
                                ArticleHorizontalItem(
                                    article = bookmark,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            navigateToWebView(bookmark.id, bookmark.url)
                                        }
                                )
                                Divider(color = Color.DarkGray)
                            }
                        }
                    }
                }
            }
        }
    }
}