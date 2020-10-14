package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angkorteam.uicompose.master.model.Person
import com.angkorteam.uicompose.master.style.Theme

class HorizontalCarouselActivity : AppCompatActivity() {
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
            val personList = getPersonList()
            val colors = getColors()
            Column {
                Text(
                    "Horizontal Scrollable Carousel", style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ), modifier = Modifier.padding(16.dp).fillMaxWidth()
                )

                ScrollableRow(modifier = Modifier.fillMaxWidth(), children = {
                    // Row is a composable that places its children in a horizontal sequence. You
                    // can think of it similar to a LinearLayout with the horizontal orientation.
                    Row {
                        // We iterate over each item from the personList and define what each item should
                        // look like.
                        for ((index, person) in personList.withIndex()) {
                            // Card composable is a predefined composable that is meant to represent the card
                            // surface as specified by the Material Design specification. We also configure it
                            // to have rounded corners and apply a modifier.

                            // You can think of Modifiers as implementations of the decorators pattern that are
                            // used to modify the composable that its applied to. In this example, we assign a
                            // padding of 16dp to the Card.
                            Card(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = colors[index % colors.size],
                                modifier = Modifier.padding(16.dp)
                            ) {
                                // The Text composable is pre-defined by the Compose UI library; you can use this
                                // composable to render text on the screen
                                Text(
                                    person.name,
                                    modifier = Modifier.padding(16.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp
                                    )
                                )
                            }
                        }
                    }
                })

                Text(
                    "Horizontal Scrolling Carousel where each item occupies the width of the screen",
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                        fontSize = 14.sp, color = Color.Black
                    ),
                    modifier = Modifier.padding(16.dp).fillMaxWidth()
                )

                ScrollableRow(modifier = Modifier.fillMaxWidth(), children = {
                    // Ambient is an implicit way to pass values down the compose tree. Typically, we pass values
                    // down the compose tree by passing them as parameters. This makes it easy to have fairly
                    // modular and reusable components that are easy to test as well. However, for certain types
                    // of data where multiple components need to use it, it makes sense to have an implicit way
                    // to access this data. For such scenarios, we use Ambients. In this example, we use the
                    // ContextAmbient to get hold of the Context object. In order to get access to the latest
                    // value of the Ambient, use the "current" property eg - ContextAmbient.current. Some other
                    // examples of common Ambient's are TextInputServiceAmbient, DensityAmbient,
                    // CoroutineContextAmbient, etc.
                    val context = ContextAmbient.current
                    val resources = context.resources
                    val displayMetrics = resources.displayMetrics
                    // Compute the screen width using the actual display width and the density of the display.
                    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
                    val spacing = 16.dp
                    // Row is a composable that places its children in a horizontal sequence. You
                    // can think of it similar to a LinearLayout with the horizontal orientation.
                    Row {
                        // We iterate over each item from the personList and define what each item should
                        // look like.
                        for ((index, person) in personList.withIndex()) {
                            // Card composable is a predefined composable that is meant to represent the card
                            // surface as specified by the Material Design specification. We also configure it
                            // to have rounded corners and apply a modifier.

                            // You can think of Modifiers as implementations of the decorators pattern that are
                            // used to modify the composable that its applied to. In this example, we assign a
                            // padding of 16dp to the Card.
                            Card(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = colors[index % colors.size],
                                modifier = Modifier.padding(16.dp)
                            ) {
                                // Box is a predefined convenience composable that allows you to apply common
                                // draw & layout logic. In addition we also pass a few modifiers to it.

                                // To ensure that the item occupies the entire screen, we make sure that the
                                // width of the box is equal to the computed screenWidth. We subtract
                                // some spacing to make the other item slightly visible.
                                Box(
                                    modifier = Modifier.preferredWidth(screenWidth.dp - (spacing * 2)),
                                    alignment = Alignment.Center
                                ) {
                                    // The Text composable is pre-defined by the Compose UI library; you can use
                                    // this composable to render text on the screen
                                    Text(
                                        text = person.name,
                                        modifier = Modifier.padding(16.dp),
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 20.sp
                                        )
                                    )
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    fun getPersonList(): List<Person> {
        return listOf(
            Person("Grace Hopper", 25),
            Person("Ada Lovelace", 29),
            Person("John Smith", 28),
            Person("Elon Musk", 41),
            Person("Will Smith", 31),
            Person("Robert James", 42),
            Person("Anthony Curry", 91),
            Person("Kevin Jackson", 22),
            Person("Robert Curry", 1),
            Person("John Curry", 9),
            Person("Ada Jackson", 2),
            Person("Joe Defoe", 35)
        )
    }

    fun getColors(): List<Color> {
        return listOf(
            Color(0xFFffd7d7.toInt()),
            Color(0xFFffe9d6.toInt()),
            Color(0xFFfffbd0.toInt()),
            Color(0xFFe3ffd9.toInt()),
            Color(0xFFd0fff8.toInt())
        )
    }

}