package com.angkorteam.uicompose.master.widget

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.R
import com.angkorteam.uicompose.master.SubscriptionActivity
import com.angkorteam.uicompose.master.style.Gray600
import com.angkorteam.uicompose.master.style.Gray900
import com.angkorteam.uicompose.master.style.Red700
import com.angkorteam.uicompose.master.style.Theme

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
    title: String,
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    val snackbarHostState = SnackbarHostState()
    val rememberScaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState)

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
            drawerContent()
        }
    ) {
        bodyContent(it)
    }
}

@Composable
fun drawerContent() {
    var context = ContextAmbient.current
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
        ListItem(icon = {
            Icon(asset = vectorResource(id = R.drawable.ic_whatshot_white_24dp), tint = Color.White)
        }) {
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
            modifier = Modifier.clickable(onClick = {
                context.startActivity(Intent(context, SubscriptionActivity::class.java))
            })
        ) {
            Text(
                "Subscriptions",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(asset = vectorResource(id = R.drawable.ic_rss_feed_white_24dp), tint = Color.White)
        }) {
            Text(
                "What's New",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(asset = vectorResource(id = R.drawable.ic_bookmark_white_24dp), tint = Color.White)
        }) {
            Text(
                "Bookmarked Playlists",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(
                asset = vectorResource(id = R.drawable.ic_file_download_white_24dp),
                tint = Color.White
            )
        }) {
            Text(
                "Downloads",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(asset = vectorResource(id = R.drawable.ic_history_white_24dp), tint = Color.White)
        }) {
            Text(
                "History",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        Divider(color = Color.Gray600)
        ListItem(icon = {
            Icon(asset = vectorResource(id = R.drawable.ic_settings_white_24dp), tint = Color.White)
        }) {
            Text(
                "Setting",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(
                asset = vectorResource(id = R.drawable.ic_info_outline_white_24dp),
                tint = Color.White
            )
        }) {
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
        drawerContent()
    }
}
