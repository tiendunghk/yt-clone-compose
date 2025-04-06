package com.d9.compose.yt.model

import java.util.UUID

data class DrawerMenu(
    val id : String = UUID.randomUUID().toString(),
    val icon : Int,
    val label : String,
    val rawColor : Boolean = false
)