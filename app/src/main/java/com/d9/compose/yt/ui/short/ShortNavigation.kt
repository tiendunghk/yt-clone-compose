package com.d9.compose.yt.ui.short

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.d9.compose.yt.SharedViewModel
import kotlinx.serialization.Serializable

@Serializable
data object ShortNavRoute

fun NavGraphBuilder.shortScreen(
    padding: PaddingValues,
    activityViewModel: SharedViewModel,
) {
    composable<ShortNavRoute> {
        ShortScreen(
            padding = padding,
            activityViewModel = activityViewModel
        )
    }
}