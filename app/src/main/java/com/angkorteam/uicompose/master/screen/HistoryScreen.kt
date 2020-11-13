package com.angkorteam.uicompose.master.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.style.Gray900
import com.angkorteam.uicompose.master.R


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
        historyBodyContent()
    }

}

@Composable
fun historyBodyContent() {
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

        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (imageRef: ConstrainedLayoutReference,
                text1Ref: ConstrainedLayoutReference,
                text2Ref: ConstrainedLayoutReference,
                text3Ref: ConstrainedLayoutReference) = createRefs()
            Image(
                asset = imageResource(id = R.drawable.hq720),
                modifier = Modifier.constrainAs(
                    imageRef
                ) {
                    start.linkTo(anchor = parent.start, margin = 0.dp)
                    top.linkTo(anchor = parent.top, margin = 0.dp)
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
                    linkTo(
                        start = imageRef.end,
                        top = parent.top,
                        bottom = parent.bottom,
                        end = parent.end,
                        startMargin = 0.dp,
                        topMargin = 0.dp,
                        endMargin = 0.dp,
                        bottomMargin = 0.dp,
                        horizontalBias = 0F,
                        verticalBias = 0f
                    )
                    width = Dimension.preferredValue(0.dp)
                }
            )
            Text(
                text = "Simply Nailogica!",
                style = MaterialTheme.typography.caption.copy(fontSize = 7.sp),
                color = Color.White,
                modifier = Modifier.constrainAs(
                    text2Ref
                ) {
                    linkTo(
                        start = imageRef.end,
                        top = text1Ref.bottom,
                        bottom = text3Ref.bottom,
                        end = parent.end,
                        startMargin = 0.dp,
                        topMargin = 0.dp,
                        endMargin = 0.dp,
                        bottomMargin = 0.dp,
                        horizontalBias = 0f,
                        verticalBias = 0f
                    )
                }
            )
            Text(
                text = "2 views 31/08/2020 * Stream",
                style = MaterialTheme.typography.caption.copy(fontSize = 6.sp),
                color = Color.White,
                modifier = Modifier.constrainAs(
                    text3Ref
                ) {
                    linkTo(
                        start = imageRef.end,
                        top = text2Ref.bottom,
                        bottom = imageRef.bottom,
                        end = parent.end,
                        startMargin = 0.dp,
                        topMargin = 0.dp,
                        endMargin = 0.dp,
                        bottomMargin = 0.dp,
                        horizontalBias = 0f,
                        verticalBias = 1f
                    )
                }
            )
        }
    }
}