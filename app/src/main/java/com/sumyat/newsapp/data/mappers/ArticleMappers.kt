package com.sumyat.newsapp.data.mappers

import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity
import com.sumyat.newsapp.data.remote.dto.ArticleDto
import com.sumyat.newsapp.domain.model.Article

fun ArticleDto.toArticle(): Article {
    return Article(
        id = 0,
        publishedAt = publishedAt ?: "",
        sourceName = source?.name,
        title = title ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: ""
    )
}

fun ArticleDto.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        publishedAt = publishedAt ?: "",
        sourceName = source?.name,
        title = title ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: ""
    )
}

fun ArticleEntity.toArticle(): Article {
    return Article(
        id = id,
        publishedAt = publishedAt,
        sourceName = sourceName,
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}

fun Article.toBookmarkEntity(): BookmarkEntity {
    return BookmarkEntity(
        title = title,
        publishedAt = publishedAt,
        sourceName = sourceName,
        url = url,
        urlToImage = urlToImage
    )
}
