package com.d9.compose.yt.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import com.d9.compose.yt.navigation.TopLevelScreen
import com.d9.compose.yt.ui.theme.basicBlack
import com.d9.compose.yt.ui.theme.basicWhite
import com.d9.compose.yt.ui.theme.brightNeutral06

@Composable
fun DTubeBottomAppBar(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    bgColor: Color,
    textColor: Color?,
    onNavigateTo: (TopLevelScreen) -> Unit,
) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
            .fillMaxWidth()
            .selectableGroup(),
        color = bgColor,
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TopLevelScreen.entries.forEach { destination ->
                BottomAppBarItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    selected = currentDestination?.route == destination.route::class.qualifiedName,
                    onClick = { onNavigateTo(destination) },
                    iconId = destination.iconId,
                    label = destination.label,
                    destination = destination,
                    textColor = textColor,
                )
            }
        }
    }
}

@Composable
fun BottomAppBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    iconId: Int?,
    label: Int?,
    modifier: Modifier = Modifier,
    destination: TopLevelScreen,
    textColor: Color?
) {
    Box(
        modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            role = Role.Tab,
            indication = null,
            onClick = onClick,
        ),
        contentAlignment = Alignment.Center
    ) {
        if (iconId != null && label != null) {
            Column(
                modifier = Modifier
                    .width(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(3.dp),
            ) {
                if (destination != TopLevelScreen.YOU) {
                    val tintColor =
                        if (textColor != null && destination == TopLevelScreen.SHORT) textColor else if (selected) MaterialTheme.colorScheme.onBackground else Color.Gray.copy(
                            0.6f
                        )
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = tintColor,
                    )
                } else {
                    val avatarBg: Color = if (selected) {
                        if (isSystemInDarkTheme()) basicWhite else basicBlack
                    } else {
                        Color.Transparent
                    }

                    Box(
                        Modifier
                            .clip(CircleShape)
                            .size(29.dp)
                            .background(avatarBg),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(iconId),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(24.dp),
                        )
                    }
                }

                Text(
                    text = stringResource(label),
                    style = MaterialTheme.typography.labelSmall
                        .merge(
                            fontSize = 9.sp,
                            color = textColor ?: MaterialTheme.colorScheme.onBackground
                        ),
                )
            }
        } else {
            Box(
                Modifier
                    .clip(CircleShape)
                    .size(48.dp)
                    .background(brightNeutral06),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    }
}