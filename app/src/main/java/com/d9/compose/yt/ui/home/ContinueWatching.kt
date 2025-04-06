package com.d9.compose.yt.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.d9.compose.yt.R
import com.d9.compose.yt.model.YtVideoInfo
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData
import com.d9.compose.yt.util.getScreenSizeDp

@Composable
fun ContinueWatching() {
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.home_str_continue_watching),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = {},
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    role = Role.Button
                )
            )
        }

        ListContinueWatching()
    }
}

@Composable
private fun ListContinueWatching() {
    val (width, _) = getScreenSizeDp()

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(DummyData.listContinueWatching.shuffled().take(7), { it.id }) { item ->
            ContinueWatchingItem(
                modifier = Modifier.width((width * 0.9f).dp), ytVideoInfo = item
            )
        }
    }
}

@Composable
private fun ContinueWatchingItem(
    modifier: Modifier = Modifier,
    ytVideoInfo: YtVideoInfo,
) {
    Column(
        modifier, verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box {
            AsyncImage(
                ytVideoInfo.thumbUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .height(210.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp, 20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xff221611).copy(0.89f))
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ytVideoInfo.durationMs,
                    color = basicWhite,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ) {
                Box(
                    Modifier.weight(1f),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = ytVideoInfo.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = ytVideoInfo.channel,
                        style = MaterialTheme.typography.bodySmall.merge(color = Color.Gray)
                    )
                    Text(
                        ".",
                        style = MaterialTheme.typography.bodySmall.merge(color = Color.Gray),
                        modifier = Modifier.offset(y = (-5).dp)
                    )
                    Text(
                        text = ytVideoInfo.viewCount.toString(),
                        style = MaterialTheme.typography.bodySmall.merge(color = Color.Gray)
                    )
                    Text(
                        ".",
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.bodySmall.merge(color = Color.Gray),
                        modifier = Modifier.offset(y = (-5).dp)
                    )
                    Text(
                        text = "3 weeks ago",
                        style = MaterialTheme.typography.bodySmall.merge(color = Color.Gray)
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.MoreVert, contentDescription = null
            )
        }
    }
}