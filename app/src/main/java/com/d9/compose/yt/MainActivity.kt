package com.d9.compose.yt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.d9.compose.yt.navigation.DTubeNavigationGraph
import com.d9.compose.yt.ui.theme.YouTubeTheme
import com.d9.compose.yt.ui.theme.basicWhite
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YouTubeTheme {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiController = rememberSystemUiController()
                val navController = rememberNavController()

                LaunchedEffect(isSystemInDarkMode) {
                    if (isSystemInDarkMode) {
                        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
                    }
                }

                Scaffold(
                    modifier = Modifier,
                    containerColor = basicWhite
                ) {
                    DTubeNavigationGraph(
                        navController = navController
                    )
                }
            }
        }
    }
}