package com.sumyat.newsapp.domain

import com.sumyat.newsapp.commom.TestUtil
import com.sumyat.newsapp.commom.FakeNewsRepository
import com.sumyat.newsapp.domain.usecase.SaveBookmarkUseCase
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SaveBookmarkUseCaseTest {

    private lateinit var saveBookmarkUseCase: SaveBookmarkUseCase
    private lateinit var fakeRepository: FakeNewsRepository

    @Before
    fun setUp() {
        fakeRepository = FakeNewsRepository()
        saveBookmarkUseCase = SaveBookmarkUseCase(fakeRepository)
        runBlocking {
            fakeRepository.saveBookmark(TestUtil.createArticle())
        }
    }

    @Test
    fun `save bookmark, find bookmark, correct bookmark`() = runBlocking {
        val anew = TestUtil.createArticle()
        saveBookmarkUseCase.invoke(anew.id ?: 0)
        val saveBookmark = fakeRepository.searchArticle(anew.id ?: 0)
        assertEquals(anew.id, saveBookmark?.id)

    }
}