package com.d9.compose.yt.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.model.FilterAction
import com.d9.compose.yt.model.TabFilter
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.brightNeutral03
import com.d9.compose.yt.ui.theme.brightNeutral05

@Composable
fun DFilterBar(
    listItems: List<TabFilter>,
    onFilterClick: (TabFilter) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(listItems, { it.id }) { item ->
            FilterChip(
                filter = item,
                onFilterClick = { onFilterClick(item) }
            )
        }
    }
}

@Composable
private fun FilterChip(
    modifier: Modifier = Modifier,
    filter: TabFilter,
    onFilterClick: (TabFilter) -> Unit
) {
    when (filter.action) {
        FilterAction.NORMAL -> Box(
            modifier = modifier
                .clip(MaterialTheme.shapes.small)
                .background(if (filter.selected) MaterialTheme.colorScheme.onBackground else brightNeutral03)
                .padding(horizontal = 8.dp, vertical = 5.dp)
                .clickable(
                    onClick = { onFilterClick(filter) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    role = Role.Tab
                ),
            contentAlignment = Alignment.Center
        ) {
            val color =
                if (filter.selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
            Text(
                text = filter.label!!,
                style = MaterialTheme.typography.titleSmall
                    .merge(
                        color
                    )
            )
        }

        FilterAction.DRAWER -> Box(
            modifier = modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .background(brightNeutral05)
                .padding(5.dp)
                .clickable(
                    onClick = { onFilterClick(filter) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    role = Role.Tab
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(YoutubeIcons.icCompass),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }

        FilterAction.FEEDBACK -> Text(
            text = filter.label!!,
            modifier.clickable(
                onClick = { onFilterClick(filter) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                role = Role.Tab
            ),
            style = MaterialTheme.typography.labelSmall
                .merge(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilterDrawer() {
    FilterChip(filter = TabFilter(action = FilterAction.DRAWER),
        onFilterClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewFilterNormal() {
    FilterChip(filter = TabFilter(label = "Tat ca"),
        onFilterClick = {})
}