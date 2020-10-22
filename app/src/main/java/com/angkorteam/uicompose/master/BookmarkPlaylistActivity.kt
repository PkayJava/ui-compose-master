package com.angkorteam.uicompose.master

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.style.Gray900
import com.angkorteam.uicompose.master.widget.frmkApp
import com.angkorteam.uicompose.master.widget.frmkScaffold

class BookmarkPlaylistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            frmkApp {
                frmkScaffold(title = "Bookmarked Playlists") {
                    bookmarkPlaylistBodyContent(it)
                }
            }
        }
    }

}

@Composable
fun bookmarkPlaylistBodyContent(padding: PaddingValues) {
    Log.i("THREAD", padding.top.toString())
}

@Preview(
    backgroundColor = 0xFFFFFF,
    device = Devices.PIXEL_4_XL,
    showBackground = true,
    name = "Bookmarked Playlists",
    fontScale = 1f,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun bookmarkPlaylistBodyContentPreview() {
    Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.width(320.dp)) {
        bookmarkPlaylistBodyContent(
            padding = PaddingValues(
                start = 10.dp,
                bottom = 10.dp,
                end = 10.dp,
                top = 10.dp
            )
        )
    }

}