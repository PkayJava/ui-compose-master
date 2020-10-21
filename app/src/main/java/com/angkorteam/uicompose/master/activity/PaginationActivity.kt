package com.angkorteam.uicompose.master.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.angkorteam.uicompose.master.model.Animal
import com.angkorteam.uicompose.master.model.AnimalViewModel
import com.angkorteam.uicompose.master.style.Theme
import kotlinx.coroutines.launch

class PaginationActivity : AppCompatActivity() {

    private lateinit var viewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)

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
        val coroutineScope = rememberCoroutineScope()

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
            val masterAnimals = viewModel.getMaster() as MutableLiveData<List<Animal>>
            val animals by masterAnimals.observeAsState(initial = emptyList())

            LazyColumnForIndexed(items = animals) { index, animal ->

                if (index == animals.lastIndex) {
                    coroutineScope.launch {
                        viewModel.loadMoreAnimal(masterAnimals)
                    }
                }

                ListItem(
                    icon = { Text(animal.emoji) },
                    text = { Text(animal.name) },
                    modifier = androidx.compose.ui.Modifier.padding(vertical = 30.dp)
                )
            }
        }
    }

}