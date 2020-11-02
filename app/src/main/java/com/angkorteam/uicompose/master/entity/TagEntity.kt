package com.angkorteam.uicompose.master.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_tag")
data class TagEntity(
    @ColumnInfo(name = "tag_id") @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
)