package com.sumyat.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sumyat.newsapp.presentation.feature.bookmark.BookmarksRoute
import com.sumyat.newsapp.presentation.feature.headline.HeadlineNewsRoute
import com.sumyat.newsapp.presentation.feature.searchnews.SearchNewsRoute
import com.sumyat.newsapp.presentation.feature.webpage.WebpageRoute

@Composable
fun BottomNavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Headline.screen_route) {

        composable(BottomNavItem.Headline.screen_route) {
            HeadlineNewsRoute(
                navigateToWebView = { id, url ->
                    navController.navigate(route = "webview/${id}?url=${url}")
                },
                modifier = modifier
            )
        }
        composable(BottomNavItem.Search.screen_route) {
            SearchNewsRoute(modifier = modifier, navigateToWebView = { id, url ->
                navController.navigate(route = "webview?url=${url}")
            })
        }

        composable(BottomNavItem.Bookmark.screen_route) {
            BookmarksRoute(
                navigateToWebView = { id, url -> navController.navigate(route = "webview?url=${url}") },
                modifier = modifier
            )
        }

        composable(ScreensRoute.WebpageWithBookmark.screen_route) {
            val id = it.arguments?.getString("id")
            val webpage = it.arguments?.getString("url")
            WebpageRoute(
                id = id?.toInt(),
                url = webpage,
                popUp = { navController.popBackStack() })
        }

        composable(ScreensRoute.Webpage.screen_route) {
            val webpage = it.arguments?.getString("url")
            WebpageRoute(
                url = webpage,
                enabledFloatingButton = false,
                popUp = { navController.popBackStack() })
        }
    }

}