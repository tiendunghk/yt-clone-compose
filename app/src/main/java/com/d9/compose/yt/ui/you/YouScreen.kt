package com.d9.compose.yt.ui.you

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.d9.compose.yt.ui.component.DYouTopAppBar
import com.d9.compose.yt.ui.theme.brightNeutral05
import com.d9.compose.yt.util.DummyData


@Composable
fun YouScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onSettingClick: () -> Unit
) {
    Column {
        DYouTopAppBar(
            modifier = Modifier
                .padding(top = padding.calculateTopPadding())
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            onSearchClick = onSearchClick,
            onCastClick = onCastClick,
            onNotificationClick = onNotificationClick,
            onSettingClick = onSettingClick
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .navigationBarsPadding()
        ) {
            item("info") {
                InfoSection()
            }

            item("item_section") {
                ListOption()
            }

            item("watched_video") {
                WatchedVideo()
            }

            item("playlist") {
                PlaylistVideo()
            }

            item("other_section") {
                OtherSection()
            }

            item {
                Spacer(modifier = Modifier.height(45.dp))
            }
        }
    }
}


@Composable
fun InfoSection() {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://yt3.ggpht.com/yti/ANjgQV9EuGNlVuRHplzwtg7GeGvcQd3DvRRMqziE0oT6qiK8GOU=s88-c-k-c0x00ffffff-no-rj"),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(54.dp),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text(text = "Dũng Nguyễn")
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(text = "@DungNguyen-yp9jd")
                Text(text = ".")
                Text(text = "Xem kênh >")
            }
        }
    }
}

@Composable
fun ListOption() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(DummyData.listYouOptions, { it.id }) { item ->
            Box(
                Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(brightNeutral05)
                    .padding(
                        horizontal = 5.dp,
                        vertical = 4.dp,
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(item.icon), contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}