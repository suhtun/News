package com.sumyat.newsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)