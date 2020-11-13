package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.material.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angkorteam.uicompose.master.style.Theme

class DisplayStyledTextActivity : AppCompatActivity() {
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

            ScrollableColumn {
                Text(
                        text = "This is the default text style",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is blue in color",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(color = Color.Blue)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text has a bigger font size",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(fontSize = 30.sp)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is bold",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is italic",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(fontStyle = FontStyle.Italic)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is using a custom font family",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(fontFamily = FontFamily.Cursive)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text has an underline",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(textDecoration = TextDecoration.Underline)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text has a strikethrough line",
                        modifier = Modifier.padding(16.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1.copy(textDecoration = TextDecoration.LineThrough)
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text will add an ellipsis to the end of the text if the text is longer that 1 line long.",
                        modifier = Modifier.padding(16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text has a shadow",
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.body1.copy(
                                shadow = Shadow(
                                        color = Color.Black,
                                        blurRadius = 10f,
                                        offset = Offset(x = 2f, y = 2f),
                                ),
                        )
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is center aligned",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Center),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is left aligned",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Left),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text is right aligned",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Right),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text will demonstrate how to justify your paragraph to ensure that the text that ends with a soft line break spreads and takes the entire width of the container",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Justify),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text will demonstrate how to justify your paragraph to ensure that the text that ends with a soft line break spreads and takes the entire width of the container",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Justify),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "This text will demonstrate how to add indentation to your text. In this example, indentation was only added to the first line. You also have the option to add indentation to the rest of the lines if you'd like",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Justify, textIndent = TextIndent(firstLine = 30.sp)),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = "The line height of this text has been increased hence you will be able to see more space between each line in this paragraph.",
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Justify, lineHeight = 20.sp),
                        modifier = Modifier.padding(16.dp).then(Modifier.fillMaxWidth())
                )
                Divider(color = Color.Gray)
                Text(
                        text = annotatedString {
                            append("This string has style spans")
                            addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
                            addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
                            addStyle(style = SpanStyle(color = Color.Blue), start = 22, end = 27)
                        },
                        modifier = Modifier.padding(16.dp)
                )
                Divider(color = Color.Gray)
                Surface(color = Color.Yellow, modifier = Modifier.fillMaxWidth()) {
                    Text(
                            text = "This text has a background color",
                            modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

}