package com.example.myhello.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// Warning: Every change of this schema will require database migration
@Dao
interface UserDao {
    @Query("SELECT * FROM Users ORDER BY name COLLATE NOCASE ASC")
    fun allUsers(): PagingSource<Int, User>

    @Query("SELECT * FROM Users ORDER BY name COLLATE NOCASE ASC")
    fun allUsers1(): PagingSource<String, User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)

    @Query("DELETE FROM users")
    fun clearAll()

    @Query("SELECT * FROM users ORDER BY RANDOM() LIMIT 1")
    fun getRandomUser(): User?
}