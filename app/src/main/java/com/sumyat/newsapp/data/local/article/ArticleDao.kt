package com.sumyat.newsapp.data.local.article

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.sumyat.newsapp.domain.model.Article

@Dao
interface ArticleDao {

    @Upsert
    suspend fun upsertAll(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articleentity")
    fun pagingSource(): PagingSource<Int, ArticleEntity>

    @Query("SELECT * FROM articleentity WHERE id=:id")
    suspend fun searchArticle(id:Int): Article

    @Query("DELETE FROM articleentity")
    suspend fun clearAll()
}