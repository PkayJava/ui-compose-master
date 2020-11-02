package com.angkorteam.uicompose.master.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "tbl_tag_friend", primaryKeys = ["friend_id", "tag_id"])
data class TagFriendEntity(
    @ColumnInfo(name = "friend_id") val friendId: Int,
    @ColumnInfo(name = "tag_id") val tagId: String,
)