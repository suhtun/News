package com.sumyat.newsapp.presentation.navigation

import com.sumyat.newsapp.R

sealed class BottomNavItem(var icon: Int, var screen_route: String) {
    object Headline : BottomNavItem(R.drawable.baseline_home_24, "headline")
    object Search : BottomNavItem(R.drawable.baseline_search_24, "search")
    object Bookmark : BottomNavItem(R.drawable.baseline_bookmarks_24, "bookmark")
}