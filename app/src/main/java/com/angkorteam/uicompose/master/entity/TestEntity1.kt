package com.angkorteam.uicompose.master.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_test1")
data class TestEntity1(
    @ColumnInfo(name = "test_id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "index") val index: Int? = null,
    @ColumnInfo(name = "guid") val guid: String? = null,
    @ColumnInfo(name = "active") val active: Boolean? = null,
    @ColumnInfo(name = "balance") val balance: String? = null,
    @ColumnInfo(name = "picture") val picture: String? = null,
    @ColumnInfo(name = "age") val age: Int? = null,
    @ColumnInfo(name = "eyeColor") val eyeColor: String? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "gender") val gender: String? = null,
    @ColumnInfo(name = "company") val company: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "phone") val phone: String? = null,
    @ColumnInfo(name = "address") val address: String? = null,
    @ColumnInfo(name = "about") val about: String? = null,
    @ColumnInfo(name = "registered") val registered: String? = null,
    @ColumnInfo(name = "latitude") val latitude: Double? = null,
    @ColumnInfo(name = "longitude") val longitude: Double? = null,
)