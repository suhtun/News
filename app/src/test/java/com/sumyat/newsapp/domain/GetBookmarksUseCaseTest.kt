package com.sumyat.newsapp.domain

import com.sumyat.newsapp.commom.TestUtil
import com.sumyat.newsapp.commom.FakeNewsRepository
import com.sumyat.newsapp.domain.usecase.GetBookmarksUserCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetBookmarksUseCaseTest {

    private lateinit var fakeRepository: FakeNewsRepository
    private lateinit var getBookmarksUserCase: GetBookmarksUserCase

    @Before
    fun setUp() {
        fakeRepository = FakeNewsRepository()
        getBookmarksUserCase = GetBookmarksUserCase(fakeRepository)

        runBlocking {
            TestUtil.createNews().forEach { fakeRepository.saveBookmark(it) }
        }
    }

    @Test
    fun `get bookmarks, correct list`()= runBlocking {
        val new = getBookmarksUserCase.invoke().first()
        assertEquals(TestUtil.createNews(),new)
    }
}