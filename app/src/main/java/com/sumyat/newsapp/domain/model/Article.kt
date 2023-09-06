package com.sumyat.newsapp.domain.model

data class Article(
    val id:Int?,
    val publishedAt: String,
    val sourceName:String?,
    val title: String,
    val url: String,
    val urlToImage: String
)
