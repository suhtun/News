package com.sumyat.newsapp.data.mappers

import com.sumyat.newsapp.commom.TestUtil
import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity
import com.sumyat.newsapp.domain.model.Article
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BookmarkMappersTest {
    private lateinit var article: Article
    private lateinit var bookmarkEntity: BookmarkEntity

    @Before
    fun setUp(){
        article = TestUtil.createArticle()
        bookmarkEntity = TestUtil.createBookEntity()
    }

    @Test
    fun `BookmarkEntity to Article`(){
        assertEquals(article, bookmarkEntity.toArticle())
    }

    @Test
    fun `BookmarkEntites to Articles`(){
        val bookmarkEntities = mutableListOf(bookmarkEntity)
        assertEquals(arrayListOf(article), toArticles(bookmarkEntities) )
    }
}