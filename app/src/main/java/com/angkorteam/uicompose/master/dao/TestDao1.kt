package com.angkorteam.uicompose.master.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.angkorteam.uicompose.master.entity.TestEntity1

@Dao
interface TestDao1 {

    @Query("SELECT * FROM tbl_test1 ORDER BY name ASC")
    fun getAlphabetizedWords(): PagingSource<String, TestEntity1>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(test: TestEntity1)

}