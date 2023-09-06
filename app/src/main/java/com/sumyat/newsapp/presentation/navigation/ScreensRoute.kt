package com.sumyat.newsapp.presentation.navigation

sealed class ScreensRoute(val screen_route:String) {
    object Webpage: ScreensRoute("webview?url={url}")
    object WebpageWithBookmark : ScreensRoute("webview/{id}?url={url}")
}