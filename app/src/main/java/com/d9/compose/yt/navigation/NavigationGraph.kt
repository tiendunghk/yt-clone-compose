package com.d9.compose.yt.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.d9.compose.yt.SharedViewModel

@Composable
fun DTubeNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    activityViewModel: SharedViewModel = hiltViewModel(),
) {
    val topLevelNavController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TopLevelNavRoute,
        modifier = modifier,
        contentAlignment = Alignment.Center,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it / 4 } },
        popEnterTransition = { slideInHorizontally { -it / 4 } },
        popExitTransition = { slideOutHorizontally { it } }) {
        topLevelScreen(
            navController = topLevelNavController,
            activityViewModel = activityViewModel
        )
    }
}