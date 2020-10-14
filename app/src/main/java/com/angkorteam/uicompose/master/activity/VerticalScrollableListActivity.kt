package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angkorteam.uicompose.master.model.Person
import com.angkorteam.uicompose.master.style.Theme
import java.util.*

class VerticalScrollableListActivity : AppCompatActivity() {
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
            LazyColumnFor(items = personList, modifier = Modifier.fillMaxHeight()) { person ->
                val index = personList.indexOf(person)
                // Row is a composable that places its children in a horizontal sequence. You
                // can think of it similar to a LinearLayout with the horizontal orientation.
                // In addition, we pass a modifier to the Row composable. You can think of
                // Modifiers as implementations of the decorators pattern that  are used to
                // modify the composable that its applied to. In this example, we configure the
                // Row to occupify the entire available width using Modifier.fillMaxWidth() and also give
                // it a padding of 16dp.
                Row(modifier = Modifier.padding(16.dp).fillParentMaxWidth()) {
                    // Card composable is a predefined composable that is meant to represent the card surface as
                    // specified by the Material Design specification. We also configure it to have rounded
                    // corners and apply a modifier.
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = colors[index % colors.size],
                        modifier = Modifier.fillParentMaxWidth()
                    ) {
                        // Text is a predefined composable that does exactly what you'd expect it to -
                        // display text on the screen. It allows you to customize its appearance using
                        // the style property.
                        Text(
                            person.name, style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ), modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    fun getPersonList(): List<Person> {
        return Arrays.asList(
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
        return Arrays.asList(
            Color(0xFFffd7d7.toInt()),
            Color(0xFFffe9d6.toInt()),
            Color(0xFFfffbd0.toInt()),
            Color(0xFFe3ffd9.toInt()),
            Color(0xFFd0fff8.toInt())
        )
    }

}