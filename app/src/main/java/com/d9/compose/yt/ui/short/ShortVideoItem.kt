package com.d9.compose.yt.ui.short

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.model.RightOption
import com.d9.compose.yt.model.ShortModel
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData.rightOptions

@Composable
fun ShortVideoItem(
    item: ShortModel,
    pageIndex: Int,
    pagerState: PagerState,
    onSingleTap: (isPlayed: Boolean) -> Unit
) {
    Box {
        ShortVideoPlayer(
            isPlayed = pagerState.settledPage == pageIndex,
            onSingleTap = onSingleTap,
            video = item,
            pageIndex = pageIndex,
        )

        Column(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            rightOptions.forEach { item ->
                RightOptionWidget(
                    option = item
                )
            }
        }

        Column(
            Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Bro is strong",
                style = MaterialTheme.typography.titleSmall
                    .merge(basicWhite)
            )
            Text(
                text = "Bro regretted it",
                style = MaterialTheme.typography.labelSmall
                    .merge(basicWhite)
            )
        }
    }
}

@Composable
private fun RightOptionWidget(
    option: RightOption
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(option.icon),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            colorFilter = ColorFilter.tint(basicWhite),
        )
        Text(
            text = option.label,
            style = MaterialTheme.typography.labelSmall
                .merge(basicWhite)
        )
    }
}