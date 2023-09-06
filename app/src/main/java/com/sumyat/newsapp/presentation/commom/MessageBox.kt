package com.sumyat.newsapp.presentation.commom

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun MesssageBox(string: String, context: Context, modifier: Modifier = Modifier) {
    LaunchedEffect(key1 = true) {
        Toast.makeText(
            context,
            string,
            Toast.LENGTH_LONG
        ).show()
    }
}