package com.sumyat.newsapp.data.local.bookmark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val title: String,
    val publishedAt: String,
    val sourceName:String?,
    val url: String,
    val urlToImage: String
)