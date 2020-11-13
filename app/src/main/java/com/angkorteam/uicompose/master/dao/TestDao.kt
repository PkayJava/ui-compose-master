package com.angkorteam.uicompose.master.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.angkorteam.uicompose.master.entity.TestEntity

@Dao
interface TestDao {

    @Query("SELECT * FROM tbl_test ORDER BY name ASC")
    fun getAlphabetizedWords(): PagingSource<Int, TestEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(test: TestEntity)

}