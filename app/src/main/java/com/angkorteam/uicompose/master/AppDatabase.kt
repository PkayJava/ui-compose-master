package com.angkorteam.uicompose.master

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.angkorteam.uicompose.master.entity.FriendEntity
import com.angkorteam.uicompose.master.entity.TagEntity
import com.angkorteam.uicompose.master.entity.TagFriendEntity
import com.angkorteam.uicompose.master.entity.TestEntity
import com.example.myhello.db.User
import com.example.myhello.db.UserDao

@Database(
    entities = [TagEntity::class, FriendEntity::class, TagFriendEntity::class, TestEntity::class, User::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }

}