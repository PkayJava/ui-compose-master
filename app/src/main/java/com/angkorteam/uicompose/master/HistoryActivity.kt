package com.angkorteam.uicompose.master

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.style.Gray900
import com.angkorteam.uicompose.master.widget.frmkApp
import com.angkorteam.uicompose.master.widget.frmkScaffold

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            frmkApp {
                frmkScaffold(title = "Last Played") {
                    Box(modifier = Modifier.fillMaxSize() then Modifier.background(Color.Gray900)) {
                        historyBodyContent(it)
                    }
                }
            }
        }
    }

}

@Composable
fun historyBodyContent(padding: PaddingValues) {
    Log.i("THREAD", padding.top.toString())
    Column {
        Row(
            modifier = Modifier.fillMaxWidth() then Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(asset = vectorResource(id = R.drawable.ic_history_black_24dp), tint = Color.White)
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "Last Played", color = Color.White)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth() then Modifier.padding(5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_headset_black_24dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "Last Played", color = Color.White)
            }
            Divider(
                modifier = Modifier.width(1.dp) then Modifier.height(20.dp),
                color = Color.White
            )
            Text(text = "Play All", color = Color.White)
            Divider(
                modifier = Modifier.width(1.dp) then Modifier.height(20.dp),
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_picture_in_picture_black_24dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "Popup", color = Color.White)
            }
        }
//        ConstraintLayout {
//            // Create references for the composables to constrain
//            val (button, text) = createRefs()
//
//            Button(
//                onClick = { /* Do something */ },
//                // Assign reference "button" to the Button composable
//                // and constrain it to the top of the ConstraintLayout
//                modifier = Modifier.constrainAs(button) {
//                    top.linkTo(parent.top, margin = 16.dp)
//                }
//            ) {
//                Text(text = "Button")
//            }
//
//            // Assign reference "text" to the Text composable
//            // and constrain it to the bottom of the Button composable
//            Text("Text", Modifier.constrainAs(text) {
//                top.linkTo(button.bottom, margin = 0.dp)
//                start.linkTo(button.end)
//            })
//        }

        ConstraintLayout {
            val (imageRef: ConstrainedLayoutReference,
                text1Ref: ConstrainedLayoutReference,
                text2Ref: ConstrainedLayoutReference,
                text3Ref: ConstrainedLayoutReference) = createRefs()
            Image(
                asset = imageResource(id = R.drawable.hq720),
                modifier = Modifier.constrainAs(
                    imageRef
                ) {
                    top.linkTo(anchor = parent.top, margin = 0.dp)
                    start.linkTo(anchor = parent.start, margin = 0.dp)
                } then Modifier.preferredWidth(100.dp)
            )
            Text(
                text = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(fontSize = 12.sp),
                color = Color.White,
                modifier = Modifier.constrainAs(
                    text1Ref
                ) {
                    start.linkTo(anchor = imageRef.end, margin = 0.dp)
                    end.linkTo(anchor = parent.end, margin = 0.dp)
                    top.linkTo(anchor = parent.top, margin = 0.dp)
                }
            )
            Text(
                text = "Simply Nailogica!",
                style = MaterialTheme.typography.caption.copy(fontSize = 7.sp),
                color = Color.White,
                modifier = Modifier.constrainAs(
                    text2Ref
                ) {
                    start.linkTo(anchor = imageRef.end, margin = 0.dp)
                    end.linkTo(anchor = parent.end, margin = 0.dp)
                    top.linkTo(anchor = text1Ref.bottom, margin = 0.dp)
                }
            )
            Text(
                text = "2 views 31/08/2020 * Stream",
                style = MaterialTheme.typography.caption.copy(fontSize = 6.sp),
                color = Color.White,
                modifier = Modifier.constrainAs(
                    text3Ref
                ) {
                    start.linkTo(imageRef.end)
                    end.linkTo(parent.end)
                    bottom.linkTo(imageRef.bottom)
                }
            )
        }

//        ScrollableColumn(modifier = Modifier.padding(5.dp)) {
//            ConstraintLayout {
//                val (imageRef: ConstrainedLayoutReference,
//                    text1Ref: ConstrainedLayoutReference,
//                    text2Ref: ConstrainedLayoutReference,
//                    text3Ref: ConstrainedLayoutReference) = createRefs()
//                Image(
//                    asset = imageResource(id = R.drawable.hq720),
//                    modifier = Modifier.preferredWidth(100.dp) then Modifier.constrainAs(
//                        imageRef
//                    ) {
//                        top.linkTo(anchor = parent.top, margin = 0.dp)
//                        start.linkTo(anchor = parent.start, margin = 0.dp)
//                    }
//                )
//                Box(
//                    modifier = Modifier.constrainAs(
//                        text1Ref
//                    ) {
//                        start.linkTo(anchor = imageRef.end, margin = 0.dp)
//                        end.linkTo(anchor = parent.end, margin = 0.dp)
//                        top.linkTo(anchor = parent.top, margin = 0.dp)
//                    }) {
//                    Text(
//                        text = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30",
//                        maxLines = 2,
//                        overflow = TextOverflow.Ellipsis,
//                        style = MaterialTheme.typography.subtitle1.copy(fontSize = 12.sp),
//                        color = Color.White,
//                    )
//                }
//                Box(
//                    modifier = Modifier.constrainAs(
//                        text2Ref
//                    ) {
//                        start.linkTo(anchor = imageRef.end, margin = 0.dp)
//                        end.linkTo(anchor = parent.end, margin = 0.dp)
//                        top.linkTo(anchor = text1Ref.bottom, margin = 0.dp)
//                    }) {
//                    Text(
//                        text = "Simply Nailogica!",
//                        style = MaterialTheme.typography.caption.copy(fontSize = 7.sp),
//                        color = Color.White,
//                    )
//                }
//                Box(
//                    modifier = Modifier.constrainAs(
//                        text3Ref
//                    ) {
//                        start.linkTo(imageRef.end)
//                        end.linkTo(parent.end)
//                        bottom.linkTo(imageRef.bottom)
//                    }) {
//                    Text(
//                        text = "2 views 31/08/2020 * Stream",
//                        style = MaterialTheme.typography.caption.copy(fontSize = 6.sp),
//                        color = Color.White
//                    )
//                }
//            }
//        }
    }
}

@Preview(
    backgroundColor = 0xFFFFFF,
    device = Devices.PIXEL_4_XL,
    showBackground = true,
    name = "Last Played",
    fontScale = 1f,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun historyBodyContentPreview() {
    Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.width(320.dp)) {
        historyBodyContent(
            padding = PaddingValues(
                start = 10.dp,
                bottom = 10.dp,
                end = 10.dp,
                top = 10.dp
            )
        )
    }

}