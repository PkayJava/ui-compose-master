package com.angkorteam.uicompose.master

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.angkorteam.uicompose.master.dao.TestDao
import com.angkorteam.uicompose.master.entity.FriendEntity
import com.angkorteam.uicompose.master.entity.TagEntity
import com.angkorteam.uicompose.master.entity.TagFriendEntity
import com.angkorteam.uicompose.master.entity.TestEntity

@Database(
    entities = [TagEntity::class, FriendEntity::class, TagFriendEntity::class, TestEntity::class],
    version = 3
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDatabase"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}