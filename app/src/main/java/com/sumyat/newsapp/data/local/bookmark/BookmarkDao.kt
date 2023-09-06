package com.sumyat.newsapp.data.local.bookmark

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmarkentity")
    fun getBookmarks(): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetBookmark(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity)

    @Query("DELETE FROM bookmarkentity")
    suspend fun clearAll()
}