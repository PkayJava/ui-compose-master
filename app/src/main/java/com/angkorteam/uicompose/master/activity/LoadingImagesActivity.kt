package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angkorteam.uicompose.master.R
import com.angkorteam.uicompose.master.style.Theme
import com.angkorteam.uicompose.master.widget.GlideImage
import com.angkorteam.uicompose.master.widget.PicassoImage

class LoadingImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                        Content()
                    }
                }
            )
        }
    }

    @Composable
    fun Content() {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "UI Compose Master",
                        style = MaterialTheme.typography.h6.copy(color = Color.White),
                    )
                })
            },
        ) {
            ScrollableColumn() {
                Text(
                    "Load image from the resource folder", style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ), modifier = Modifier.padding(16.dp).fillMaxWidth()
                )
                val image = loadImageResource(id = R.drawable.landscape)
                image.resource.resource?.let {
                    // Image is a pre-defined composable that lays out and draws a given [ImageAsset].

                    // You can think of Modifiers as implementations of the decorators pattern that are
                    // used to modify the composable that its applied to. In this example, we configure the
                    // Image composable to have a height of 200 dp.
                    Image(
                        asset = it,
                        modifier = Modifier.preferredSizeIn(maxHeight = 200.dp)
                            .fillMaxWidth()
                    )
                }
                Text(
                    "Load image from url using Picasso", style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ), modifier = Modifier.padding(16.dp).fillMaxWidth()
                )
                PicassoImage(url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
                Text(
                    "Load image from url using Glide", style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ), modifier = Modifier.padding(16.dp).fillMaxWidth()
                )
                GlideImage(url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
                Text(
                    "Image with rounded corners", style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ), modifier = Modifier.padding(16.dp).fillMaxWidth()
                )
                image.resource.resource?.let {
                    // Box is a predefined convenience composable that allows you to apply common draw & layout
                    // logic. In addition we also pass a few modifiers to it.

                    // You can think of Modifiers as implementations of the decorators pattern that are
                    // used to modify the composable that its applied to. In this example, we configure the
                    // Box composable to clip the corners of the image.
                    Box(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp))
                    ) {
                        // Image is a pre-defined composable that lays out and draws a given [ImageAsset].
                        Image(
                            asset = it,
                            modifier = Modifier.preferredHeight(200.dp)
                        )
                    }
                }
            }
        }
    }

}