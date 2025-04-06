package com.d9.compose.yt.ui.you

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.d9.compose.yt.R
import com.d9.compose.yt.model.YtVideoInfo
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData

@Composable
fun WatchedVideo() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.str_watched_video),
                fontWeight = FontWeight.Bold
            )
            Box(
                Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(15.dp))
                    .padding(
                        horizontal = 10.dp,
                        vertical = 4.dp,
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.str_view_all),
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(DummyData.listContinueWatching, { it.id }) { item ->
                WatchedItem(
                    modifier = Modifier.width(160.dp),
                    item = item
                )
            }
        }
    }
}

@Composable
fun WatchedItem(
    modifier: Modifier = Modifier,
    item: YtVideoInfo,
) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box {
            AsyncImage(
                item.thumbUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(45.dp, 20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xff221611).copy(0.89f))
                    .align(Alignment.BottomEnd), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "18:23",
                    color = basicWhite,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }

        Row {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = item.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall
                )


                Text(
                    text = item.channel,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                        .merge(Color.Gray)
                )
            }

            Icon(
                imageVector = Icons.Default.MoreVert,
                modifier = Modifier.size(14.dp),
                contentDescription = null
            )
        }
    }
}