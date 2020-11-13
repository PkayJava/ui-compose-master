package com.angkorteam.uicompose.master.activity

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import com.angkorteam.uicompose.master.client.TestPagingSource
import com.angkorteam.uicompose.master.entity.TestEntity
import kotlinx.coroutines.flow.Flow

class MyBackend {

    fun getAllData(): PagingSource<Int, String> {
        return TestPagingSource()
    }
}

@Composable
fun PagingBackendSample(pager: Pager<Int, TestEntity>) {
    val lazyPagingItems = pager.flow.collectAsLazyPagingItems()
    Log.i("THREAD", "==================================")
    Log.i("THREAD", "loadState.refresh          " + lazyPagingItems.loadState.refresh.toString())
    Log.i("THREAD", "loadState.append           " + lazyPagingItems.loadState.append.toString())
    Log.i("THREAD", "loadState.prepend          " + lazyPagingItems.loadState.prepend.toString())

    Log.i("THREAD", "loadState.source           " + lazyPagingItems.loadState.source.toString())
    Log.i(
        "THREAD",
        "loadState.source.refresh   " + lazyPagingItems.loadState.source.refresh.toString()
    )
    Log.i(
        "THREAD",
        "loadState.source.append    " + lazyPagingItems.loadState.source.append.toString()
    )
    Log.i(
        "THREAD",
        "loadState.source.prepend   " + lazyPagingItems.loadState.source.prepend.toString()
    )

    Log.i("THREAD", "loadState.mediator         " + lazyPagingItems.loadState.mediator.toString())
    Log.i(
        "THREAD",
        "loadState.mediator.refresh " + lazyPagingItems.loadState.mediator?.refresh.toString()
    )
    Log.i(
        "THREAD",
        "loadState.mediator.append  " + lazyPagingItems.loadState.mediator?.append.toString()
    )
    Log.i(
        "THREAD",
        "loadState.mediator.prepend " + lazyPagingItems.loadState.mediator?.prepend.toString()
    )
    LazyColumn {
        if (lazyPagingItems.loadState.source.refresh == LoadState.Loading || lazyPagingItems.loadState.mediator?.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "Waiting for items to load from the backend",
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
        itemsIndexed(lazyPagingItems) { index, item ->
            Text("Index=$index: $item", fontSize = 20.sp)
        }
        if (lazyPagingItems.loadState.source.append == LoadState.Loading || lazyPagingItems.loadState.mediator?.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun ItemsDemo(flow: Flow<PagingData<String>>) {
    val lazyPagingItems = flow.collectAsLazyPagingItems()
    LazyColumn {
        items(lazyPagingItems) {
            Text("Item is $it")
        }
    }
}

@Composable
fun ItemsIndexedDemo(flow: Flow<PagingData<String>>) {
    val lazyPagingItems = flow.collectAsLazyPagingItems()
    LazyColumn {
        itemsIndexed(lazyPagingItems) { index, item ->
            Text("Item at index $index is $item")
        }
    }
}