package com.sumyat.newsapp.presentation.feature.webpage

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumyat.newsapp.R
import com.sumyat.newsapp.presentation.commom.MesssageBox

@Composable
fun WebpageRoute(
    id: Int?=0,
    url: String?,
    enabledFloatingButton: Boolean = true,
    popUp: () -> Unit,
    viewModel: WebpageViewModel = hiltViewModel()
) {
    val webpageUiState by viewModel.webpageUiState.collectAsState()
    WebpageScreen(
        url = url,
        popUp = { popUp() },
        enabledFloatingButton = enabledFloatingButton,
        webpageUiState = webpageUiState,
        saveBookmark = { viewModel.bookmarkArticle(id) })
}

@Composable
fun WebpageScreen(
    url: String?,
    enabledFloatingButton: Boolean = true,
    webpageUiState: WebpageUiState,
    popUp: () -> Unit,
    saveBookmark: () -> Unit
) {
    Log.d("bookmark", "webpage ${enabledFloatingButton}")
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()

    when (webpageUiState) {
        is WebpageUiState.SavedArticle -> {
            MesssageBox(stringResource(id = R.string.saved_bookmark_message), context)
        }

        is WebpageUiState.FailureToSaveArticle -> {
            MesssageBox(webpageUiState.error, context)
        }

        else -> {}

    }
    Scaffold(
        floatingActionButton = {
            if (enabledFloatingButton) {
                FloatingActionButton(
                    onClick = {
                        saveBookmark()
                    },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_bookmark_add_24),
                        contentDescription = "Bookmark Add"
                    )
                }
            }
        },
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AndroidView(
                modifier = Modifier
                    .fillMaxSize(),
                factory = {
                    WebView(it).apply {
                        webViewClient = WebViewClient()
                        if (url != null) {
                            loadUrl(url)
                        }
                    }
                }
            )

            IconButton(
                onClick = {
                    popUp()
                }
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Popup",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(32.dp)
                        .shadow(12.dp, RoundedCornerShape(8.dp)),
                    tint = Color.White,
                )
            }
        }
    }
}
