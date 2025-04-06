package com.d9.compose.yt.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.d9.compose.yt.model.ShortHomeModel
import com.d9.compose.yt.model.YtVideoInfo
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.basicBlack
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData

@Composable
fun ShortGrid() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Image(
                    painter = painterResource(YoutubeIcons.icShortList),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp, 65.dp)
                )
                Text(
                    text = "Shorts",
                    style = MaterialTheme.typography.titleMedium,
                    color = basicBlack
                )
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }

        LazyVerticalGrid(
            modifier = Modifier.height(535.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(DummyData.listShortHome.shuffled().take(4), { it.id }) { item ->
                ShortItem(item = item)
            }
        }
    }
}

@Composable
private fun ShortItem(
    item: ShortHomeModel,
) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .height(260.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopEnd),
            tint = basicWhite
        )
        Text(
            text = "A golden boy",
            color = basicWhite,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .padding(6.dp)
                .align(Alignment.BottomStart)
        )
    }
}