package com.d9.compose.yt.model

import java.util.UUID

data class YouOptionSection(
    val id : String = UUID.randomUUID().toString(),
    val icon : Int,
    val label : String,
)
