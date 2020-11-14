package com.example.myhello.db

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class JsonObject(
    @Json(name = "name") val name: String?,
    @Json(name = "version") val version: String?,
    @Json(name = "lockfileVersion") val lockfileVersion: Int?,
    @Json(name = "requires") val requires: Boolean?,
    @Json(name = "dependencies") val dependencies: Map<String, Dependency>?,
)

@JsonClass(generateAdapter = true)
class Dependency(
    @Json(name = "resolved") val resolved: String?,
    @Json(name = "version") val version: String?,
    @Json(name = "integrity") val integrity: String?,
    @Json(name = "dev") val dev: Boolean?,
)

