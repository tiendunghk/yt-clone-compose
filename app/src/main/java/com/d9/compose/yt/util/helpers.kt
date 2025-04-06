package com.d9.compose.yt.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun getScreenSizeDp(): Pair<Int, Int> {
    val configuration = LocalConfiguration.current
    return remember(configuration) {
        configuration.screenWidthDp to configuration.screenHeightDp
    }
}