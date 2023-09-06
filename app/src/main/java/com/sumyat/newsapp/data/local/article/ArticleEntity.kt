package com.sumyat.newsapp.data.local.article

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sumyat.newsapp.data.remote.dto.SourceDto

@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val publishedAt: String,
    val sourceName:String?,
    val title: String,
    val url: String,
    val urlToImage: String
)