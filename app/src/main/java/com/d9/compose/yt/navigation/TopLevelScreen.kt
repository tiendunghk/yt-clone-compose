package com.d9.compose.yt.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.d9.compose.yt.R
import com.d9.compose.yt.ui.home.HomeNavRoute
import com.d9.compose.yt.ui.short.ShortNavRoute
import com.d9.compose.yt.ui.subscriptions.SubscriptionsNavRoute
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.you.YouNavRoute

enum class TopLevelScreen(
    val route: Any,
    @DrawableRes val iconId: Int?,
    @StringRes val label: Int?,
) {
    HOME(
        HomeNavRoute,
        YoutubeIcons.icHome,
        R.string.label_homepage
    ),
    SHORT(
        ShortNavRoute,
        YoutubeIcons.icShort,
        R.string.label_short
    ),
    ADD(
        "null",
        null,
        null
    ),
    SUBSCRIPTIONS(
        SubscriptionsNavRoute,
        YoutubeIcons.icSubChannel,
        R.string.label_subscriptions
    ),
    YOU(
        YouNavRoute,
        YoutubeIcons.icMine,
        R.string.label_you
    )
}