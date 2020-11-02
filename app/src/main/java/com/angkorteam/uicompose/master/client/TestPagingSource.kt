package com.angkorteam.uicompose.master.client

import android.util.Log
import androidx.paging.PagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.math.ceil

class TestPagingSource : PagingSource<Int, String>() {

    private val backendDataList = (0..60).toList().map { "[Item $it is from backend]" }
    val DataBatchSize = 5

    class DesiredLoadResultPageResponse(
        val data: List<String>
    )

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
//        return withContext(Dispatchers.IO) {
        // Simulate latency
        delay(2000)
        Log.i("THREAD", "PagingSource load " + Thread.currentThread().name)
        Log.i("THREAD", "Test")


//            val pp = OkHttpClient()
//            val ss =
//                pp.newCall(
//                    Request.Builder().get().url("http://192.168.1.10/page01.json").build()
//                )
//                    .execute()
//            ss.use {
//                ss.body?.close()
//                Log.i("THREAD", "Code " + ss.code.toString())
//            }

        val pageNumber = params.key ?: 0
        val response = searchItemsByKey(pageNumber)
        // Since 0 is the lowest page number, return null to signify no more pages should
        // be loaded before it.
        val prevKey = if (pageNumber > 0) pageNumber - 1 else null
        // This API defines that it's out of data when a page returns empty. When out of
        // data, we return `null` to signify no more pages should be loaded
        val nextKey = if (response.data.isNotEmpty()) pageNumber + 1 else null
        return LoadResult.Page(
            data = response.data,
            prevKey = prevKey,
            nextKey = nextKey
        )
//        }
    }

    fun searchItemsByKey(key: Int): DesiredLoadResultPageResponse {
        val maxKey = ceil(backendDataList.size.toFloat() / DataBatchSize).toInt()
        if (key >= maxKey) {
            return DesiredLoadResultPageResponse(emptyList())
        }
        val from = key * DataBatchSize
        val to = minOf((key + 1) * DataBatchSize, backendDataList.size)
        val currentSublist = backendDataList.subList(from, to)
        return DesiredLoadResultPageResponse(currentSublist)
    }

}