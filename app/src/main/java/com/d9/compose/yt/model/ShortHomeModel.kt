package com.d9.compose.yt.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class ShortHomeModel(
    val id : String = UUID.randomUUID().toString(),
    @DrawableRes val image : Int
)