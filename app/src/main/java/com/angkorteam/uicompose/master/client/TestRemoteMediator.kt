package com.angkorteam.uicompose.master.client

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.angkorteam.uicompose.master.entity.TestEntity
import com.angkorteam.uicompose.master.model.TestModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


@ExperimentalPagingApi
class TestRemoteMediator : RemoteMediator<Int, TestEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TestEntity>
    ): MediatorResult {
        // load data from remote and save into sqlite
        Log.i(
            "THREAD",
            "RemoteMediator load " + Thread.currentThread().name + " loadType " + loadType.name
        )

        withContext(Dispatchers.IO) {

            if (loadType == LoadType.REFRESH) {
                // load first page
                val pp = OkHttpClient()
                var request = Request.Builder().get().url("http://192.168.1.10/page01.json").build()
                var response = pp.newCall(request).execute()
                response.use {
                    if (response.body != null) {
                        response.body.use {
                            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                            val listMyData = Types.newParameterizedType(
                                MutableList::class.java,
                                TestModel::class.java
                            )
                            val jsonAdapter: JsonAdapter<List<TestModel>> =
                                moshi.adapter(listMyData)
                            var ppsss = jsonAdapter.fromJson(response.body!!.source())
                            Log.i("THREAD", ppsss!!.size.toString())
                            Log.i("THREAD", "Test")
                        }
                    }
                }

            } else {

            }
        }
        return MediatorResult.Success(false)
    }

}