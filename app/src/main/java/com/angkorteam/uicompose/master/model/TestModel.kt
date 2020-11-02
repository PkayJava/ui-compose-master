package com.angkorteam.uicompose.master.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TestModel(
    @Json(name = "_id") var id: String? = null,
    @Json(name = "index") var index: Int? = null,
    @Json(name = "guid") var guid: String? = null,
    @Json(name = "isActive") var active: Boolean? = null,
    @Json(name = "balance") var balance: String? = null,
    @Json(name = "picture") var picture: String? = null,
    @Json(name = "age") var age: Int? = null,
    @Json(name = "eyeColor") var eyeColor: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "gender") var gender: String? = null,
    @Json(name = "company") var company: String? = null,
    @Json(name = "email") var email: String? = null,
    @Json(name = "phone") var phone: String? = null,
    @Json(name = "address") var address: String? = null,
    @Json(name = "about") var about: String? = null,
    @Json(name = "registered") var registered: String? = null,
    @Json(name = "latitude") var latitude: Double? = null,
    @Json(name = "longitude") var longitude: Double? = null,
    @Json(name = "tags") var tags: List<String>? = null,
    @Json(name = "friends") var friends: List<FriendModel>? = null,
    @Json(name = "greeting") var greeting: String? = null,
    @Json(name = "favoriteFruit") var favoriteFruit: String? = null,
)