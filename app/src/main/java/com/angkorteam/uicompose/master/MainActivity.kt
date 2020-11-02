package com.angkorteam.uicompose.master

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.screen.Screen
import com.angkorteam.uicompose.master.style.Gray600
import com.angkorteam.uicompose.master.style.Gray900
import com.angkorteam.uicompose.master.style.Red700
import com.angkorteam.uicompose.master.style.Theme

class MainActivity : AppCompatActivity() {

    @ExperimentalLazyDsl
    @ExperimentalMaterialApi
    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var appContext = AppContext(appDatabase = (this.applicationContext as MainApplication).appDatabase)

        setContent {
            val controller = rememberNavController()
            val snackbarHostState = SnackbarHostState()
            val scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState)

            frmkApp {
                NavHost(controller, startDestination = Screen.Trending.route) {
                    composable(Screen.Trending.route) {
                        Screen.Trending.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.Subscription.route) {
                        Screen.Subscription.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.WhatIsNew.route) {
                        Screen.WhatIsNew.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.BookmarkPlaylist.route) {
                        Screen.BookmarkPlaylist.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.Download.route) {
                        Screen.Download.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.History.route) {
                        Screen.History.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.Setting.route) {
                        Screen.Setting.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                    composable(Screen.About.route) {
                        Screen.About.Content(
                            appContext = appContext,
                            scaffoldState = scaffoldState,
                            controller = controller,
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun frmkApp(content: @Composable () -> Unit) {
    val darkTheme: Boolean = isSystemInDarkTheme()
    val colors = if (darkTheme) {
        Theme.Default.darkColors
    } else {
        Theme.Default.lightColors
    }

    MaterialTheme(
        colors = colors,
        typography = Theme.Default.typography,
        shapes = Theme.Default.shapes,
        content = {
            Surface(color = MaterialTheme.colors.background) {
                content()
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun frmkScaffold(
    scaffoldState: ScaffoldState?,
    controller: NavHostController?,
    title: String,
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    var rememberScaffoldState = scaffoldState ?: rememberScaffoldState()
    Scaffold(
        scaffoldState = rememberScaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h6.copy(color = Color.White),
                    )
                }, navigationIcon = {
                    IconButton(onClick = { rememberScaffoldState.drawerState.open() }) {
                        Icon(asset = Icons.Default.Menu)
                    }
                }
            )
        },
        drawerShape = MaterialTheme.shapes.small,
        drawerBackgroundColor = Color.Gray900,
        drawerContent = {
            drawerContent(scaffoldState = rememberScaffoldState, controller = controller)
        }
    ) {
        bodyContent(it)
    }
}

@Composable
fun drawerContent(scaffoldState: ScaffoldState?, controller: NavHostController?) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth() then Modifier.background(color = Color.Red700),
            alignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                asset = imageResource(id = R.drawable.background_header)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    contentScale = ContentScale.FillWidth,
                    asset = vectorResource(id = R.drawable.splash_foreground)
                )
                Text("NewPipe", style = MaterialTheme.typography.h3, color = Color.White)
            }
        }
        Divider()
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_whatshot_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(
                onClick = {
                    scaffoldState?.drawerState?.close()
                    controller?.navigate(route = Screen.Trending.route)
                },
            )
        ) {
            Text(
                "Trending",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(asset = vectorResource(id = R.drawable.ic_tv_white_24dp), tint = Color.White)
            },
            modifier = Modifier.clickable(
                onClick = {
                    scaffoldState?.drawerState?.close()
                    controller?.navigate(route = Screen.Subscription.route)
                },
            )
        ) {
            Text(
                "Subscriptions",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_rss_feed_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(onClick = {
                scaffoldState?.drawerState?.close()
                controller?.navigate(route = Screen.WhatIsNew.route)
            })
        ) {
            Text(
                "What's New",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_bookmark_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(onClick = {
                scaffoldState?.drawerState?.close()
                controller?.navigate(route = Screen.BookmarkPlaylist.route)
            }),
        ) {
            Text(
                "Bookmarked Playlists",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_file_download_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(onClick = {
                scaffoldState?.drawerState?.close()
                controller?.navigate(route = Screen.Download.route)
            }),
        ) {
            Text(
                "Downloads",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_history_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(
                onClick = {
                    scaffoldState?.drawerState?.close()
                    controller?.navigate(route = Screen.History.route)
                }
            ),
        ) {
            Text(
                "History",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        Divider(color = Color.Gray600)
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_settings_white_24dp),
                    tint = Color.White
                )
            },
            modifier = Modifier.clickable(
                onClick = {
                    scaffoldState?.drawerState?.close()
                    controller?.navigate(route = Screen.Setting.route)
                }
            ),
        ) {
            Text(
                "Setting",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(
            icon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_info_outline_white_24dp),
                    tint = Color.White,
                )
            },
            modifier = Modifier.clickable(
                onClick = {
                    scaffoldState?.drawerState?.close()
                    controller?.navigate(route = Screen.About.route)
                }
            ),
        ) {
            Text(
                "About",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }

    }
}

@Preview(
    backgroundColor = 0xFFFFFF,
    device = Devices.PIXEL_4_XL,
    showBackground = true,
    name = "Menu Drawer",
    fontScale = 1f,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun drawerHeadPreview() {
    Box(modifier = Modifier.background(Color.Gray900)) {
        drawerContent(scaffoldState = null, controller = null)
    }
}