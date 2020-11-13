//package com.angkorteam.uicompose.master
//
//import android.content.res.Configuration
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.ScrollableColumn
//import androidx.compose.material.Text
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.ExperimentalLazyDsl
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.setContent
//import androidx.compose.ui.res.imageResource
//import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.navigate
//import androidx.navigation.compose.rememberNavController
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.ui.tooling.preview.Devices
//import androidx.ui.tooling.preview.Preview
//import com.angkorteam.uicompose.master.activity.MyBackend
//import com.angkorteam.uicompose.master.activity.PagingBackendSample
//import com.angkorteam.uicompose.master.client.TestRemoteSource
//import com.angkorteam.uicompose.master.screen.bookmarkPlaylistBodyContent
//import com.angkorteam.uicompose.master.screen.downloadBodyContent
//import com.angkorteam.uicompose.master.style.Gray900
//import com.angkorteam.uicompose.master.widget.frmkScaffold
//
//class HistoryActivity : AppCompatActivity() {
//
//    @ExperimentalPagingApi
//    @ExperimentalLazyDsl
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
////            frmkApp {
////                frmkScaffold(title = "Last Played") {
////                    Box(modifier = Modifier.fillMaxSize() then Modifier.background(Color.Gray900)) {
////                        historyBodyContent(it)
////                    }
////                }
////            }
////            BasicNav()
//
////            var sbcp = rememberCoroutineScope()
//            val myBackend = remember { MyBackend() }
//            val pager = remember {
//                Pager(
//                    config = PagingConfig(
//                        pageSize = 5,
//                        enablePlaceholders = false,
//                        maxSize = 200
//                    ),
//                    remoteMediator = TestRemoteSource()
//                ) {
//                    myBackend.getAllData()
//                }
//            }
//            PagingBackendSample(pager)
//        }
//    }
//
//}
//
//
//
//@Composable
//fun BasicNav() {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = Screen.BookmarkPlaylist.route) {
//        composable(Screen.BookmarkPlaylist.route) { Profile(navController) }
//        composable(Screen.Download.route) { Dashboard(navController) }
//        composable(Screen.Scrollable.route) { Scrollable(navController) }
//    }
//}
//
//@Composable
//fun Profile(navController: NavHostController) {
//    Column(Modifier.fillMaxSize().then(Modifier.padding(8.dp))) {
//        Text(text = Screen.BookmarkPlaylist.route)
//        NavigateButton(Screen.Download.route) {
//            navController.navigate(Screen.Download.route)
//        }
//        Divider(color = Color.Black)
//        NavigateButton(Screen.Scrollable.route) {
//            navController.navigate(Screen.Scrollable.route)
//        }
//        Spacer(ModifierScreen.Subscription.route.weight(1f))
//        NavigateBackButton(navController)
//    }
//}
//
//@Composable
//fun Dashboard(navController: NavController, title: String? = null) {
//    Column(Modifier.fillMaxSize().then(Modifier.padding(8.dp))) {
//        Text(text = title ?: Screen.Download.route)
//        Spacer(Modifier.weight(1f))
//        NavigateBackButton(navController)
//    }
//}
//
//@Composable
//fun Scrollable(navController: NavController) {
//    Column(Modifier.fillMaxSize().then(Modifier.padding(8.dp))) {
//        NavigateButton(Screen.Download.route) {
//            navController.navigate(Screen.Download.route)
//        }
//        ScrollableColumn(Modifier.weight(1f)) {
//            phrases.forEach { phrase ->
//                Text(phrase, fontSize = 30.sp)
//            }
//        }
//        NavigateBackButton(navController)
//    }
//}
//
//@Composable
//fun NavigateButton(
//    text: String,
//    listener: () -> Unit = { }
//) {
//    Button(
//        onClick = listener,
//        colors = ButtonConstants.defaultButtonColors(backgroundColor = Color.LightGray),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Text(text = "Navigate to $text")
//    }
//}
//
//@Composable
//fun NavigateBackButton(navController: NavController) {
//    if (navController.previousBackStackEntry != null) {
//        Button(
//            onClick = { navController.popBackStack() },
//            colors = ButtonConstants.defaultButtonColors(backgroundColor = Color.LightGray),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Go to Previous screen")
//        }
//    }
//}
//
//private val phrases = listOf(
//    "Easy As Pie",
//    "Wouldn't Harm a Fly",
//    "No-Brainer",
//    "Keep On Truckin'",
//    "An Arm and a Leg",
//    "Down To Earth",
//    "Under the Weather",
//    "Up In Arms",
//    "Cup Of Joe",
//    "Not the Sharpest Tool in the Shed",
//    "Ring Any Bells?",
//    "Son of a Gun",
//    "Hard Pill to Swallow",
//    "Close But No Cigar",
//    "Beating a Dead Horse",
//    "If You Can't Stand the Heat, Get Out of the Kitchen",
//    "Cut To The Chase",
//    "Heads Up",
//    "Goody Two-Shoes",
//    "Fish Out Of Water",
//    "Cry Over Spilt Milk",
//    "Elephant in the Room",
//    "There's No I in Team",
//    "Poke Fun At",
//    "Talk the Talk",
//    "Know the Ropes",
//    "Fool's Gold",
//    "It's Not Brain Surgery",
//    "Fight Fire With Fire",
//    "Go For Broke"
//)
