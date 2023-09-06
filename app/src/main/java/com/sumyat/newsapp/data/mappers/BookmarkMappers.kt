package com.sumyat.newsapp.data.mappers

import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity
import com.sumyat.newsapp.domain.model.Article

fun BookmarkEntity.toArticle(): Article{
    return Article(
        id = id,
        title = title,
        publishedAt = publishedAt,
        sourceName = sourceName,
        url = url,
        urlToImage = urlToImage
    )
}

fun toArticles(bookmarkentities: List<BookmarkEntity>): List<Article>{
    return bookmarkentities.map { it.toArticle() }
}


