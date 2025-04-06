package com.d9.compose.yt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _darkBottomBarStateFlow = MutableStateFlow(false)
    val darkBottomBarStateFlow = _darkBottomBarStateFlow.asStateFlow()
    fun changeBottomBarColor(dark: Boolean = false) {
        _darkBottomBarStateFlow.value = dark
    }
}