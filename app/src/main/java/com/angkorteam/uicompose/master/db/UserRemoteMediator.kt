package com.example.myhello.db

import android.content.Context
import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.myhello.AppDatabase
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


@ExperimentalPagingApi
class UserRemoteMediator(var context: Context) : RemoteMediator<Int, User>() {


    override suspend fun load(loadType: LoadType, state: PagingState<Int, User>): MediatorResult {
        return withContext(Dispatchers.IO) {
            var client: OkHttpClient = OkHttpClient.Builder().build()
            var response =
                client.newCall(
                    Request.Builder()
                        .url("https://raw.githubusercontent.com/webroo/dummy-json/master/package-lock.json")
                        .get().build()
                )

            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

            val adapter: JsonAdapter<JsonObject> = moshi.adapter(JsonObject::class.java)

            var body = response.execute()

            var pp = adapter.fromJson(body.body!!.source())

            val dao: UserDao = AppDatabase.getInstance(context).userDao()
            pp?.dependencies?.forEach { (t, u) ->
                // dao.insert(User(id = 0, t))
            }

            Log.i("Test", "test 3")

            body.body!!.close()
            body.close()

            Log.i("Test", "body.code ${body.code}")
            Log.i("Test", "state.anchorPosition ${state.anchorPosition}")
            Log.i("Test", "state.pages.size ${state.pages.size}")
            Log.i("Test", "state.config.pageSize ${state.config.pageSize}")
            Log.i("Test", "state.config.prefetchDistance ${state.config.prefetchDistance}")
            Log.i("Test", "state.config.pageSize ${state.config.pageSize}")
            MediatorResult.Success(endOfPaginationReached = false)
        }
    }

}