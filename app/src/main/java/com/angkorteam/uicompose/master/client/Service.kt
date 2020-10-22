package com.angkorteam.uicompose.master.client

import com.angkorteam.uicompose.master.model.TestModel
import retrofit2.http.GET

interface Service {

    @GET("/page_1.json")
    suspend fun page1(): List<TestModel>

    @GET("/page_2.json")
    suspend fun page2(): List<TestModel>

    @GET("/page_3.json")
    suspend fun page3(): List<TestModel>

}