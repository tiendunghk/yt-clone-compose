package com.d9.compose.yt.model

import java.util.UUID


data class TabFilter(
    val id: String = UUID.randomUUID().toString(),
    val iconId: Int? = null,
    val label: String? = null,
    val action: FilterAction = FilterAction.NORMAL,
    val selected: Boolean = false,
)

enum class FilterAction {
    NORMAL,
    DRAWER,
    FEEDBACK
}