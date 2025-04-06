package com.d9.compose.yt.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.d9.compose.yt.model.YtVideoInfo
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData

@Composable
fun ListVideoHomepage() {
    DummyData.listContinueWatching.shuffled().take(8).forEach { item ->
        VideoItem(
            ytVideoInfo = item,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun VideoItem(
    modifier: Modifier = Modifier,
    ytVideoInfo: YtVideoInfo,
) {
    Column(
        modifier.padding(top = 25.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box {
            AsyncImage(
                ytVideoInfo.thumbUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .height(210.dp)
            )
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp, 20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xff221611).copy(0.89f))
                    .align(Alignment.BottomEnd), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ytVideoInfo.durationMs,
                    color = basicWhite,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(horizontal = 12.dp),
        ) {
            Image(
                painter = rememberAsyncImagePainter(ytVideoInfo.channelAvatarUrl),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(54.dp),
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = ytVideoInfo.title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = ytVideoInfo.channel,
                        style = MaterialTheme.typography.bodySmall
                            .merge(color = Color.Gray)
                    )
                    Text(
                        ".",
                        style = MaterialTheme.typography.bodySmall
                            .merge(color = Color.Gray),
                        modifier = Modifier.offset(y = (-5).dp)
                    )
                    Text(
                        text = ytVideoInfo.viewCount.toString(),
                        style = MaterialTheme.typography.bodySmall
                            .merge(color = Color.Gray)
                    )
                    Text(
                        ".",
                        style = MaterialTheme.typography.bodySmall
                            .merge(color = Color.Gray),
                        modifier = Modifier.offset(y = (-5).dp)
                    )
                    Text(
                        text = "3 weeks ago", fontSize = 12.sp,
                        style = MaterialTheme.typography.bodySmall
                            .merge(color = Color.Gray)
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
    }
}