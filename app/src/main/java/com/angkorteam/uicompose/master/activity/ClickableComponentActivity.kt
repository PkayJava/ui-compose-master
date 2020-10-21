package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.angkorteam.uicompose.master.style.Theme

class ClickableComponentActivity : AppCompatActivity() {
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
            // Reacting to state changes is core to how Jetpack Compose works. This state variable "showPopup"
            // is used to control whether the popup should be shown. The value is toggled every time the
            // text "Click to see dialog" is clicked. Every time the value of this variable changes,
            // the relevant sub-composables that use showPopup are automatically recomposed.
            var showPopup by remember { mutableStateOf(false) }
            // Box with clickable modifier wraps the child composable and enables it to react to a click
            // through the onClick callback similar to the onClick listener that we are accustomed to
            // on Android.
            // Here, we just change the value of showPopup to be true every time we click on the text that
            // says "Click to see Popup"
            Box(
                Modifier.clickable(onClick = { showPopup = true }),
                children = {
                    // You can think of Modifiers as implementations of the decorators pattern that are used to
                    // modify the composable that its applied to. In the example below, we add a padding of
                    // 8dp to the Card composable and 16dp to the Text composable.
                    Card(
                        shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp),
                        backgroundColor = Color.LightGray
                    ) {
                        // The Text composable is pre-defined by the Compose UI library; you can use this
                        // composable to render text on the screen
                        Text(
                            text = "Click to see dialog", modifier = Modifier.padding(16.dp),
                            style = TextStyle(
                                fontSize = TextUnit.Sp(16),
                                fontFamily = FontFamily.Serif
                            )
                        )
                    }
                })

            // A lambda that toggles the showPopup value to off. We pass it to the onDismiss equivalent
            // callback of the AlertDialog.
            val onPopupDismissed = { showPopup = false }

            // We want to show the popup only if the showPopup variable is toggled to true. Since Jetpack
            // Compose uses the declarative way of programming, we can easily decide what needs to shows
            // vs hidden based on which branch of code is being executed. In this example, we display the
            // AlertDialog only when the showPopup variable is set to true or else this branch is not
            // executed at all and thus the alert dialog remains hidden.
            if (showPopup) {
                // Predefined composable provided by the material implementations of Jetpack Compose. It
                // shows a simple alert dialog on the screen if this code path is executed (i.e showPopup
                // variable is true)
                AlertDialog(
                    onDismissRequest = onPopupDismissed,
                    text = {
                        Text("Congratulations! You just clicked the text successfully")
                    },
                    confirmButton = {
                        // Button is a pre-defined Material Design implementation of a contained button -
                        // https://material.io/design/components/buttons.html#contained-button.
                        Button(
                            onClick = onPopupDismissed
                        ) {
                            // The Button composable allows you to provide child composables that inherit
                            // this button functionality.
                            // The Text composable is pre-defined by the Compose UI library; you can use this
                            // composable to render text on the screen
                            Text(text = "Ok")
                        }
                    }
                )
            }
        }
    }

}