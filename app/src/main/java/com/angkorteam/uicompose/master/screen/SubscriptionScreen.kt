package com.angkorteam.uicompose.master.screen

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.angkorteam.uicompose.master.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.angkorteam.uicompose.master.style.Gray600
import com.angkorteam.uicompose.master.style.Gray900


@Preview(
    backgroundColor = 0xFFFFFF,
    device = Devices.PIXEL_4_XL,
    showBackground = true,
    name = "Subscription",
    fontScale = 1f,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun subscriptionBodyContentPreview() {
    Box(modifier = Modifier.background(color = Color.Gray900) then Modifier.width(320.dp)) {
        subscriptionBodyContent()
    }

}

@Composable
fun subscriptionBodyContent() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Channel Groups", style = MaterialTheme.typography.h5, color = Color.White)
        Spacer(modifier = Modifier.size(5.dp))
        Row() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.preferredSize(50.dp) then Modifier.border(
                    width = 1.dp,
                    color = Color.White,
                    shape = MaterialTheme.shapes.small
                )
            ) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_rss_feed_white_24dp),
                    tint = Color.White
                )
                Text(text = "ALL", color = Color.White)
            }
            Spacer(modifier = Modifier.size(5.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.preferredSize(50.dp) then Modifier.border(
                    width = 1.dp,
                    color = Color.White,
                    shape = MaterialTheme.shapes.small
                )
            ) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_add_white_24dp),
                    tint = Color.White
                )
                Text(text = "NEW", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.size(5.dp))
        Divider(color = Color.Gray600)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Subscriptions", style = MaterialTheme.typography.h5, color = Color.White)
            Icon(
                asset = vectorResource(id = R.drawable.ic_arrow_drop_up_white_24dp),
                tint = Color.White,
                modifier = Modifier.preferredSize(24.dp)
            )
        }
        Text(text = "Import From", color = Color.White)
        ListItem(icon = {
            Icon(
                asset = vectorResource(id = R.drawable.ic_backup_black_24dp),
                tint = Color.White,
                modifier = Modifier.preferredSize(24.dp)
            )
        }) {
            Text(
                "Previous Export",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(
                asset = imageResource(id = R.drawable.place_holder_youtube),
                tint = Color.White,
                modifier = Modifier.preferredSize(24.dp)
            )
        }) {
            Text(
                "Youtube",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        ListItem(icon = {
            Icon(
                asset = imageResource(id = R.drawable.place_holder_cloud),
                tint = Color.White,
                modifier = Modifier.preferredSize(24.dp)
            )
        }) {
            Text(
                "SoundCloud",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
        Text(text = "Export To", color = Color.White)
        ListItem(icon = {
            Icon(
                asset = vectorResource(id = R.drawable.ic_save_white_24dp),
                tint = Color.White,
                modifier = Modifier.preferredSize(24.dp)
            )
        }) {
            Text(
                "File",
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
            )
        }
    }
}