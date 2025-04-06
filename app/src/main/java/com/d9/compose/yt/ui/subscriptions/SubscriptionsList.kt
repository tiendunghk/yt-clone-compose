package com.d9.compose.yt.ui.subscriptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.d9.compose.yt.R
import com.d9.compose.yt.model.SubscriptionModel
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.getScreenSizeDp

@Composable
fun ListSubscriptions(
    listItems: List<SubscriptionModel>,
    onSubscriptionClick: (SubscriptionModel) -> Unit
) {
    val (width, _) = getScreenSizeDp()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val itemWidth = (width - 10 * 5 - 35 - 10 - 12) / 5
        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(listItems, { it.id }) { item ->
                SubscriptionItem(
                    itemWidth = itemWidth.dp,
                    item = item,
                    onSubscriptionClick = onSubscriptionClick,
                    modifier = Modifier.width(itemWidth.dp)
                )
            }
        }
        Column {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.str_all),
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .width(35.dp),
                    style = MaterialTheme.typography.labelMedium
                        .merge(Color.Blue)
                )
            }
            Text(
                text = "",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun SubscriptionItem(
    itemWidth: Dp,
    modifier: Modifier = Modifier,
    item: SubscriptionModel,
    onSubscriptionClick: (SubscriptionModel) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(
            onClick = {
                onSubscriptionClick(item)
            },
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            role = Role.Button,
        )
    ) {
        Box {
            Image(
                painter = rememberAsyncImagePainter(item.avatarUrl),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(itemWidth)
            )
            if (item.newUpdate) {
                Box(
                    Modifier
                        .offset(x = (-2).dp, y = (-2).dp)
                        .clip(CircleShape)
                        .size(14.dp)
                        .background(basicWhite)
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .clip(CircleShape)
                            .size(10.dp)
                            .background(Color.Blue)
                    )
                }
            }
        }
        Text(
            text = item.channel,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(64.dp),
            style = MaterialTheme.typography.labelSmall
        )
    }
}