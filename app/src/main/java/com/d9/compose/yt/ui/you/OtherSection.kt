package com.d9.compose.yt.ui.you

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.basicBlack
import com.d9.compose.yt.util.DummyData.listOtherSection

@Composable
fun OtherSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        listOtherSection.forEach { subList ->
            subList.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = (if (item.icon == YoutubeIcons.icPremium) null else MaterialTheme.colorScheme.onBackground)?.let {
                            ColorFilter.tint(
                                it
                            )
                        }
                    )
                    Text(text = item.label)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(basicBlack)
            )
        }
    }
}