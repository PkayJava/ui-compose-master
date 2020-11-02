package com.angkorteam.uicompose.master.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FriendModel(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
)