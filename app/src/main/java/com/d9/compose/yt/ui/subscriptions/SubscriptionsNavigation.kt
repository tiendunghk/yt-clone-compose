package com.d9.compose.yt.ui.subscriptions

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SubscriptionsNavRoute

fun NavGraphBuilder.subscriptionsScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    composable<SubscriptionsNavRoute> {
        SubscriptionsScreen(
            padding = padding,
            onSearchClick = onSearchClick,
            onCastClick = onCastClick,
            onNotificationClick = onNotificationClick
        )
    }
}