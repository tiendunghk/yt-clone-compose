package com.d9.compose.yt.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.d9.compose.yt.model.TabFilter
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavRoute

fun NavGraphBuilder.homeScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onFilterClick: (TabFilter) -> Unit
) {
    composable<HomeNavRoute> {
        HomeScreen(
            padding = padding,
            onSearchClick = onSearchClick,
            onCastClick = onCastClick,
            onNotificationClick = onNotificationClick,
            onFilterClick = onFilterClick,
        )
    }
}
