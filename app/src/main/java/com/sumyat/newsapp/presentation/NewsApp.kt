package com.sumyat.newsapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sumyat.newsapp.presentation.navigation.BottomNavigation
import com.sumyat.newsapp.presentation.navigation.BottomNavigationGraph
import com.sumyat.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp() {
    NewsAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            Scaffold(bottomBar = { BottomNavigation(navController = navController) }) {
                BottomNavigationGraph(
                    navController = navController,
                    modifier = Modifier.padding(it)
                )
            }
        }
    }
}