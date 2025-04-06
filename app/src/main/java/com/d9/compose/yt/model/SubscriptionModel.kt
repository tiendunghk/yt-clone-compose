package com.d9.compose.yt.model

import java.util.UUID

data class SubscriptionModel (
    val id : String = UUID.randomUUID().toString(),
    val channel : String,
    val avatarUrl : String,
    val newUpdate : Boolean = false
)
