package com.d9.compose.yt.model

import java.util.UUID

data class YtVideoInfo(
    val id : String = UUID.randomUUID().toString(),
    val title : String,
    val channel : String,
    val viewCount : String,
    val time : String,
    val durationMs : String,
    val channelAvatarUrl : String,
    val thumbUrl : String,
)
