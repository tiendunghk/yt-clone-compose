package com.d9.compose.yt.ui.home

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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.basicBlack
import com.d9.compose.yt.util.DummyData.listDrawerMenu

@Composable
fun HomeDrawer(
    modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    textColor: Color
) {
    Box(
        modifier
    ) {
        Column(
            Modifier.systemBarsPadding()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Image(
                    painter = painterResource(YoutubeIcons.icYt),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    text = "Premium",
                    style = MaterialTheme.typography.headlineSmall
                        .merge(textColor),
                )
            }
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                listDrawerMenu.forEachIndexed { index, subList ->
                    subList.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(item.icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                colorFilter = if (item.rawColor) null else ColorFilter.tint(
                                    MaterialTheme.colorScheme.onBackground
                                )
                            )
                            Text(
                                text = item.label,
                                style = MaterialTheme.typography.bodyLarge
                                    .merge(textColor)
                            )
                        }
                    }

                    if (index != listDrawerMenu.size - 1) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.5.dp)
                                .background(basicBlack)
                        )
                    }
                }
            }
        }
        Text(
            text = buildAnnotatedString {
                append("Chính sách quyền riêng tư")
                append(" . ")
                append("Điều khoản sử dụng")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 12.dp)
                .padding(bottom = 20.dp),
            style = MaterialTheme.typography.labelSmall
                .merge(Color.Gray)
        )
    }
}