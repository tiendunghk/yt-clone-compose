package com.d9.compose.yt.model

import java.util.UUID

data class ShortModel(
    val id : String = UUID.randomUUID().toString(),
    val shortVideo : String
)
