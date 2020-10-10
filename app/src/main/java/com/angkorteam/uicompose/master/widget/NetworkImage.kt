package com.angkorteam.uicompose.master.widget

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import com.google.common.hash.Hashing
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.commons.io.FileUtils
import java.io.File
import java.net.Proxy
import java.nio.charset.StandardCharsets
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

internal val executor: ScheduledExecutorService by lazy {
    Executors.newScheduledThreadPool(3);
}

internal val client: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .proxy(Proxy.NO_PROXY)
        .build()
}

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Inside,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val cacheDir = File(ContextAmbient.current.cacheDir, "cached-images")
    cacheDir.mkdirs()

    val local = Hashing.sha256().hashString(url, StandardCharsets.UTF_8).toString()
    val cacheFile = File(cacheDir, local)
    val (imageResource, setImageResource) = remember {
        if (cacheFile.exists()) {
            mutableStateOf(cacheFile.absolutePath)
        } else {
            mutableStateOf("")
        }
    }

    if ("" != imageResource) {
        Image(
            asset = BitmapFactory.decodeFile(cacheFile.absolutePath).asImageAsset(),
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            alpha = alpha,
            colorFilter = colorFilter
        )
    } else {
        executor.execute {
            val request: Request = Request.Builder()
                .url(url)
                .build()
            client.newCall(request).execute().use { response ->
                FileUtils.writeByteArrayToFile(cacheFile, response.body?.bytes())
                setImageResource(local)
            }
        }
    }
}
