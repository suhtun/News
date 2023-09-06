package com.sumyat.newsapp.data.mappers

import com.sumyat.newsapp.commom.TestUtil
import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity
import com.sumyat.newsapp.data.remote.dto.ArticleDto
import com.sumyat.newsapp.domain.model.Article
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArticleMappersTest {

    private lateinit var article: Article
    private lateinit var articleEntity: ArticleEntity
    private lateinit var articleDto: ArticleDto
    private lateinit var bookmarkEntity: BookmarkEntity

    @Before
    fun setUp(){
        article = TestUtil.createArticle()
        articleEntity = TestUtil.createArticleEntity()
        articleDto = TestUtil.createArticleDto()
        bookmarkEntity = TestUtil.createBookEntity()
    }

    @Test
    fun `map ArticleEntity to Article`(){
        assertEquals(article,articleEntity.toArticle())
    }

    @Test
    fun `map ArticleDto to Article`(){
        assertEquals(article, articleDto.toArticle())
    }

    @Test
    fun `map ArticleDto to ArticleEntity`(){
        val mapToArticleEntity = articleDto.toArticleEntity()
        assertEquals(articleEntity.publishedAt,mapToArticleEntity.publishedAt)
        assertEquals(articleEntity.sourceName,mapToArticleEntity.sourceName)
        assertEquals(articleEntity.title,mapToArticleEntity.title)
        assertEquals(articleEntity.url,mapToArticleEntity.url)
        assertEquals(articleEntity.urlToImage,mapToArticleEntity.urlToImage)
    }

    @Test
    fun `map Article to BookmarkEntity`(){
        val mapToBookmarkEntity = articleDto.toArticleEntity()
        assertEquals(articleEntity.publishedAt,mapToBookmarkEntity.publishedAt)
        assertEquals(articleEntity.sourceName,mapToBookmarkEntity.sourceName)
        assertEquals(articleEntity.title,mapToBookmarkEntity.title)
        assertEquals(articleEntity.url,mapToBookmarkEntity.url)
        assertEquals(articleEntity.urlToImage,mapToBookmarkEntity.urlToImage)
    }
}