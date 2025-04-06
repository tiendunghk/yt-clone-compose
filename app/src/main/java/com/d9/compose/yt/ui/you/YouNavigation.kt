package com.d9.compose.yt.ui.you

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object YouNavRoute

fun NavGraphBuilder.youScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onSettingClick: () -> Unit
) {
    composable<YouNavRoute> {
        YouScreen(
            padding = padding,
            onSearchClick = onSearchClick,
            onCastClick = onCastClick,
            onNotificationClick = onNotificationClick,
            onSettingClick = onSettingClick
        )
    }
}