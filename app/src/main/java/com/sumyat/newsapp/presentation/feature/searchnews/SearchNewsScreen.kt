package com.sumyat.newsapp.presentation.feature.searchnews

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.presentation.commom.ArticleHorizontalItem

@Composable
fun SearchNewsRoute(
    navigateToWebView: (id: Int?, url: String) -> Unit,
    viewModel: SearchNewsViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val articles = viewModel.searchNews().collectAsLazyPagingItems()
    val searchQuery by viewModel.searchQuery.collectAsState()
    SearchNewsScreen(
        articles,
        searchQuery = searchQuery,
        onSearchQueryChanged = { viewModel.updateSearchQuery(it) },
        navigateToWebView = { id, url ->
            navigateToWebView(id, url)

        },
        modifier = modifier
    )
}

@Composable
fun SearchNewsScreen(
    articles: LazyPagingItems<Article>,
    searchQuery: String?,
    onSearchQueryChanged: (String) -> Unit,
    navigateToWebView: (id: Int?, url: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = articles.loadState) {
        if (articles.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                (articles.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchQuery ?: "",
            onValueChange = {
                onSearchQueryChanged(it)
            },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp),
            singleLine = true,
            placeholder = { Text(text = "Search") }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 12.dp )
        ) {
            if (articles.loadState.refresh is LoadState.Loading && searchQuery != null) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(articles) { article ->
                        if (article != null) {
                            ArticleHorizontalItem(
                                article = article,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navigateToWebView(article.id, article.url)
                                    }
                            )
                            Divider(color = Color.DarkGray)
                        }
                    }
                    item {
                        if (articles.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}