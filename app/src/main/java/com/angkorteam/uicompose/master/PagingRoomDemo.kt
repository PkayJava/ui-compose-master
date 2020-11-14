package com.angkorteam.uicompose.master

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.sp
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.myhello.db.StringUserRemoteMediator
import com.example.myhello.db.User
import com.example.myhello.db.UserDao
import com.example.myhello.db.UserRemoteMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

@ExperimentalPagingApi
@Composable
fun PagingRoomDemo() {
    val context = ContextAmbient.current
    val dao: UserDao = AppDatabase.getInstance(context).userDao()
    val scope = rememberCoroutineScope()

    val pageSize = 10
    val pager = remember {
        Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = true,
                maxSize = 200
            ),
            remoteMediator = StringUserRemoteMediator(context = context)
        ) {
            dao.allUsers1()
        }
    }

    Column {
        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                val name = Names[Random.nextInt(Names.size)]
                dao.insert(User(id = 0, name = name))
            }
        }) {
            Text("Add random user")
        }

        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                dao.clearAll()
            }
        }) {
            Text("Clear all users")
        }

        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                val randomUser = dao.getRandomUser()
                if (randomUser != null) {
                    dao.delete(randomUser)
                }
            }
        }) {
            Text("Remove random user")
        }

        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                val randomUser = dao.getRandomUser()
                if (randomUser != null) {
                    val updatedUser = User(
                        randomUser.id,
                        randomUser.name + " updated"
                    )
                    dao.update(updatedUser)
                }
            }
        }) {
            Text("Update random user")
        }

        val lazyPagingItems = pager.flow.collectAsLazyPagingItems()
        LazyColumn {
            itemsIndexed(lazyPagingItems) { index, user ->
                Text("$index " + user?.name, fontSize = 50.sp)
            }
        }
    }
}

val Names = listOf(
    "John",
    "Jack",
    "Ben",
    "Sally",
    "Tom",
    "Jinny",
    "Mark",
    "Betty",
    "Liam",
    "Noah",
    "Olivia",
    "Emma",
    "Ava"
)