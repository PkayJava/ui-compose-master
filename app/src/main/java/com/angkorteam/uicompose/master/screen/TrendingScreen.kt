package com.angkorteam.uicompose.master.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.angkorteam.uicompose.master.AppContext
import com.angkorteam.uicompose.master.activity.PagingBackendSample
import com.angkorteam.uicompose.master.client.TestRemoteMediator

@ExperimentalPagingApi
@Composable
fun trendingBodyContent(appContext: AppContext) {
    val pager = remember {
        Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false,
                maxSize = 200,
                prefetchDistance = 5
            ),
            remoteMediator = TestRemoteMediator()
        ) {
            appContext.appDatabase.testDao().getAlphabetizedWords()
        }
    }
    PagingBackendSample(pager)

}