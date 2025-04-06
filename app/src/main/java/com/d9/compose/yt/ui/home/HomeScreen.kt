package com.d9.compose.yt.ui.home

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.model.TabFilter
import com.d9.compose.yt.ui.component.DTopAppBar
import com.d9.compose.yt.ui.theme.basicBlack
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onFilterClick: (TabFilter) -> Unit,
) {
    var showAppBar by remember { mutableStateOf(true) }
    val lazyListState = rememberLazyListState()

    lazyListState.lastScrolledForward
    val systemUiController = rememberSystemUiController()
    val isDarkMode = isSystemInDarkTheme()

    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.isScrollInProgress }
            .distinctUntilChanged()
            .collect {
                Log.d("dunghk99", "scroll: $it")
                if (lazyListState.isScrollInProgress) {
                    val scrollingUp = lazyListState.lastScrolledBackward
                    showAppBar = scrollingUp
                    val color = if (isDarkMode) basicBlack.copy(0.7f) else basicWhite.copy(0.7f)
                    systemUiController.setStatusBarColor(
                        color = color,
                        darkIcons = scrollingUp && !isDarkMode
                    )
                }
            }
    }

    LazyColumn(
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.navigationBarsPadding()
    ) {
        item("header") {
            DTopAppBar(
                modifier = Modifier
                    .padding(top = padding.calculateTopPadding())
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                onSearchClick = onSearchClick,
                onCastClick = onCastClick,
                onNotificationClick = onNotificationClick,
            )
        }

        item("filter_bar") {
            DFilterBar(
                listItems = DummyData.homeFilter,
                onFilterClick = {
                    onFilterClick(it)
                }
            )
        }

        item("continue_watching") {
            ContinueWatching()
        }

        item("stack") {
            StackWidget("https://i3.ytimg.com/vi/6CLKldA4zDQ/maxresdefault.jpg")
        }

        item("list_video") {
            ListVideoHomepage()
        }

        item("short") {
            ShortGrid()
        }

        item("list_video2") {
            ListVideoHomepage()
        }

        item {
            Spacer(modifier = Modifier.height(45.dp))
        }
    }
}