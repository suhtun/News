package com.sumyat.newsapp.presentation.feature.headline

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.sumyat.newsapp.domain.model.Article
import androidx.paging.compose.items
import com.sumyat.newsapp.presentation.commom.ArticleVerticalItemView

@Composable
fun HeadlineNewsRoute(
    navigateToWebView: (id:Int?,url: String) -> Unit,
    viewModel: HeadlineNewsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val articles = viewModel.headlinenewsPagingFlow.collectAsLazyPagingItems()
    HeadlineNewsScreen(
        articles = articles,
        navigateToWebView = { id,url -> navigateToWebView(id,url) },
        modifier = modifier)
}

@Composable
fun HeadlineNewsScreen(
    articles: LazyPagingItems<Article>,
    navigateToWebView: (id:Int?,url: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = articles.loadState) {
        if (articles.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (articles.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 12.dp )
    ) {
        if (articles.loadState.refresh is LoadState.Loading) {
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
                        ArticleVerticalItemView(
                            article = article,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navigateToWebView(article.id,article.url) }
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