package com.angkorteam.uicompose.master.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.angkorteam.uicompose.master.AppContext
import com.angkorteam.uicompose.master.frmkScaffold
import com.angkorteam.uicompose.master.style.Gray900

sealed class Screen(val route: String) {

    @Composable
    abstract fun Content(
        appContext: AppContext,
        scaffoldState: ScaffoldState?,
        controller: NavHostController?
    )

    object BookmarkPlaylist : Screen("BookmarkPlaylist") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "Bookmarked Playlists"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    bookmarkPlaylistBodyContent()
                }
            }
        }
    }

    object Download : Screen("Downloads") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "Download"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    downloadBodyContent()
                }
            }
        }
    }

    object History : Screen("History") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "History"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    historyBodyContent()
                }
            }
        }
    }

    object Subscription : Screen("Subscription") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "Subscriptions"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    subscriptionBodyContent()
                }
            }
        }
    }

    object Trending : Screen("Trending") {

        @ExperimentalPagingApi
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "Trending"
            ) {
                Box(modifier = Modifier.background(color = Color.White) then Modifier.fillMaxSize()) {
                    trendingBodyContent(appContext = appContext)
                }
            }
        }
    }

    object WhatIsNew : Screen("WhatIsNew") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "What's New"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    whatIsNewBodyContent()
                }
            }
        }
    }

    object Setting : Screen("Setting") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(
                scaffoldState = scaffoldState,
                controller = controller,
                title = "Setting"
            ) {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    settingBodyContent()
                }
            }
        }
    }

    object About : Screen("About") {
        @Composable
        override fun Content(
            appContext: AppContext,
            scaffoldState: ScaffoldState?,
            controller: NavHostController?
        ) {
            frmkScaffold(scaffoldState = scaffoldState, controller = controller, title = "About") {
                Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.fillMaxSize()) {
                    aboutBodyContent(appContext = appContext)
                }
            }
        }
    }

}
