package com.d9.compose.yt.ui.short

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.model.ShortFilter
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.util.DummyData.shortFilters

@Composable
fun ShortFilters() {
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        shortFilters.forEach { item ->
            ShortFilterItem(
                filter = item
            )
        }
    }
}

@Composable
private fun ShortFilterItem(
    modifier: Modifier = Modifier,
    filter: ShortFilter,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color(0x5E5E6A).copy(alpha = 0.7f))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(filter.icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(basicWhite),
            )
            Text(
                text = filter.label,
                style = MaterialTheme.typography.labelLarge
                    .merge(basicWhite)
            )
        }
    }
}