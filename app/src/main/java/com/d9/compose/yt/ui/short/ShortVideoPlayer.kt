package com.d9.compose.yt.ui.short

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import com.d9.compose.yt.model.ShortModel
import com.d9.compose.yt.util.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(UnstableApi::class)
@Composable
fun ShortVideoPlayer(
    pageIndex: Int,
    video: ShortModel,
    onSingleTap: (isPlayed: Boolean) -> Unit,
    isPlayed: Boolean
) {
    val context = LocalContext.current
    var thumbnail by rememberSaveable {
        mutableStateOf<Pair<Bitmap?, Boolean>>(Pair(null, true))
    }

    val exoPlayer by remember {
        mutableStateOf<ExoPlayer?>(
            ExoPlayer.Builder(context).build().apply {
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
                repeatMode = Player.REPEAT_MODE_ONE
                setMediaItem(MediaItem.fromUri(Uri.parse(video.shortVideo)))
                playWhenReady = isPlayed
                prepare()
            })
    }

    val playerView = remember {
        PlayerView(context).apply {
            player = exoPlayer
            useController = false
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    LaunchedEffect(isPlayed) {
        if (!isPlayed) {
            withContext(Dispatchers.IO) {
                try {
                    val bm = FileUtils.getThumb(
                        video.shortVideo,
                    )
                    withContext(Dispatchers.Main) {
                        thumbnail = thumbnail.copy(first = bm, second = thumbnail.second)
                    }
                } catch (_: Exception) {

                }
            }
        }
    }

    if (isPlayed) {
        Log.d("dunghk99", "isPlayed : $pageIndex")
        val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
        DisposableEffect(key1 = lifecycleOwner) {
            val lifeCycleObserver = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_STOP -> {
                        Log.d("dunghk99", "Lifecycle.Event.ON_STOP : $pageIndex")
                        exoPlayer?.pause()
                        onSingleTap(false)
                    }

                    Lifecycle.Event.ON_START -> exoPlayer?.play()
                    else -> {

                    }
                }
            }
            lifecycleOwner.lifecycle.addObserver(lifeCycleObserver)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(lifeCycleObserver)
            }
        }

        AndroidView(
            factory = {
                playerView
            }, modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onTap = {
                    if (exoPlayer?.isPlaying == true) {
                        exoPlayer?.pause()
                    } else {
                        exoPlayer?.play()
                    }
                    onSingleTap(exoPlayer?.isPlaying == true)
                }, onDoubleTap = { offset ->

                })
            })

        DisposableEffect(key1 = Unit) {
            onDispose {
                exoPlayer?.release()
                Log.d("dunghk99", "dispose video : $pageIndex")
            }
        }
    }

    if (!isPlayed && thumbnail.first != null)
        AsyncImage(
            model = thumbnail.first,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
}