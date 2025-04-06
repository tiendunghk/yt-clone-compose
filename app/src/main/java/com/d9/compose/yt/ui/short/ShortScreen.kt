package com.d9.compose.yt.ui.short

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.d9.compose.yt.SharedViewModel
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.ui.theme.neutral01
import com.d9.compose.yt.util.DummyData.listShorts
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun ShortScreen(
    padding: PaddingValues,
    activityViewModel: SharedViewModel,
) {
    val pagerState = rememberPagerState { listShorts.size }
    var showTab by remember {
        mutableStateOf(false)
    }

    var isPlaying by remember {
        mutableStateOf(false)
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(Unit) {
        systemUiController.setStatusBarColor(
            color = Color.Black, darkIcons = false
        )

        systemUiController.setNavigationBarColor(
            color = Color.Black, darkIcons = false
        )
    }

    LaunchedEffect(Unit) {
        activityViewModel.changeBottomBarColor(true)
    }

    val isSystemInDarkMode = isSystemInDarkTheme()
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                // Called when the screen is no longer visible
                systemUiController.setStatusBarColor(
                    color = Color.Transparent, darkIcons = !isSystemInDarkMode
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent, darkIcons = true
                )
                activityViewModel.changeBottomBarColor(false)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    if (showTab) {
        LaunchedEffect(Unit) {
            delay(3.seconds)
            showTab = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(top = padding.calculateTopPadding()),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .align(Alignment.TopCenter)
                .zIndex(1f),
        ) {
            AnimatedVisibility(
                visible = showTab
            ) {
                Text(
                    text = "Shorts",
                    color = basicWhite,
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null, tint = basicWhite
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = basicWhite
                )
            }
        }

        AnimatedVisibility(
            visible = showTab, modifier = Modifier
                .padding(top = 100.dp)
                .zIndex(1f)
        ) {
            ShortFilters()
        }

        AnimatedVisibility(
            visible = showTab, modifier = Modifier
                .align(Alignment.Center)
                .zIndex(1f)
        ) {
            Box(
                Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(neutral01),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = if (isPlaying) painterResource(YoutubeIcons.icPlay) else painterResource(
                        YoutubeIcons.icPause
                    ), tint = basicWhite, contentDescription = null, modifier = Modifier.size(40.dp)
                )
            }
        }

        VerticalPager(
            state = pagerState,
            contentPadding = PaddingValues(bottom = padding.calculateTopPadding())
        ) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                ShortVideoItem(
                    item = listShorts[index],
                    pageIndex = index,
                    pagerState = pagerState,
                    onSingleTap = {
                        showTab = !showTab
                        isPlaying = it
                    }
                )
            }
        }
    }
}