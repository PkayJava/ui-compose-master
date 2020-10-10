package com.angkorteam.uicompose.master

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.angkorteam.uicompose.master.activity.DisplayStyledTextActivity
import com.angkorteam.uicompose.master.activity.DisplayTextActivity
import com.angkorteam.uicompose.master.style.Theme

class MainActivity : AppCompatActivity() {
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
            var context = ContextAmbient.current
            ScrollableColumn() {
                Spacer(modifier = Modifier.height(16.dp))
                Item(
                    title = "Display Text",
                    onClick = {
                        startActivity(Intent(context, DisplayTextActivity::class.java))
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
                Item(
                    title = "Display Styled Text",
                    onClick = {
                        startActivity(Intent(context, DisplayStyledTextActivity::class.java))
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Vertical Scrollable List")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Horizontal Carousel")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Loading Images")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Clickable Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Drawer App Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Buttons Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "State Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Custom View Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Custom View Paint Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Measuring Scale Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Text Input Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Stack Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "View Layout Arrangements Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Material Design Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Fixed Action Button Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Constraint Layout Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Bottom Navigation Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Rotation Animation Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Changing Color Animation Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Text Inline Content Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "List Animation Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Theme Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Layout Modifier Components")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Save State During Process Death")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Live Data Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Filter Chips Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Shadow Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Coroutine Flow Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Compose In Classic Android Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Back Press Component")
                Spacer(modifier = Modifier.height(16.dp))
                Item(title = "Zoomable Component")
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    @Composable
    fun Item(title: String, onClick: (() -> Unit)? = null) {
        if (onClick != null) {
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(64.dp)
                    .clickable(
                        onClick = onClick
                    ),
                shape = RoundedCornerShape(4.dp),
            ) {
                Box(modifier = Modifier.fillMaxSize(), alignment = Alignment.Center) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.body1.copy(
                            color = Color.White,
                        )
                    )
                }
            }
        } else {
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(64.dp),
                shape = RoundedCornerShape(4.dp),
            ) {
                Box(modifier = Modifier.fillMaxSize(), alignment = Alignment.Center) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.body1.copy(
                            color = Color.White,
                        )
                    )
                }
            }
        }
    }

}