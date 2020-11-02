package com.angkorteam.uicompose.master.entity

import androidx.room.*

@Entity(tableName = "tbl_friend")
data class FriendEntity(
    @ColumnInfo(name = "friend_id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
)