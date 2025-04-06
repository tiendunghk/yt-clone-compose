package com.d9.compose.yt.navigation

import android.widget.Toast
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.d9.compose.yt.R
import com.d9.compose.yt.SharedViewModel
import com.d9.compose.yt.model.FilterAction
import com.d9.compose.yt.ui.component.DTubeBottomAppBar
import com.d9.compose.yt.ui.home.HomeDrawer
import com.d9.compose.yt.ui.home.HomeNavRoute
import com.d9.compose.yt.ui.home.homeScreen
import com.d9.compose.yt.ui.short.shortScreen
import com.d9.compose.yt.ui.subscriptions.subscriptionsScreen
import com.d9.compose.yt.ui.theme.DarkColorScheme
import com.d9.compose.yt.ui.you.youScreen
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data object TopLevelNavRoute

fun NavGraphBuilder.topLevelScreen(
    navController: NavHostController,
    activityViewModel: SharedViewModel,
) {
    composable<TopLevelNavRoute> {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(DrawerValue.Closed)

        val darkBottomBar by activityViewModel.darkBottomBarStateFlow.collectAsState()
        val isDarkMode = isSystemInDarkTheme()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                HomeDrawer(
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surface),
                    textColor = MaterialTheme.colorScheme.onBackground
                )
            }) {
            Scaffold(
                bottomBar = {
                    val bgColor =
                        if (darkBottomBar && !isDarkMode) DarkColorScheme.surface else MaterialTheme.colorScheme.surface
                    DTubeBottomAppBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(1f),
                        currentDestination = currentDestination,
                        bgColor = bgColor,
                        textColor = if (darkBottomBar && !isDarkMode) DarkColorScheme.onBackground else null
                    ) { destination ->
                        if (destination != TopLevelScreen.ADD) {
                            navController.navigate(
                                route = destination.route,
                                navOptions {
                                    currentDestination?.route?.let { route ->
                                        popUpTo(route) {
                                            inclusive = true
                                            saveState = true
                                        }
                                    }
                                    restoreState = true
                                }
                            )
                        } else {
                            Toast.makeText(
                                context,
                                R.string.str_feature_develop,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
            ) { padding ->
                NavHost(
                    modifier = Modifier.zIndex(1f),
                    navController = navController,
                    startDestination = HomeNavRoute,
                    contentAlignment = Alignment.Center,
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() }
                ) {
                    homeScreen(
                        padding = padding,
                        onCastClick = {},
                        onSearchClick = {},
                        onNotificationClick = {},
                        onFilterClick = {
                            if (it.action == FilterAction.DRAWER) {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        }
                    )
                    shortScreen(
                        padding = padding,
                        activityViewModel = activityViewModel
                    )
                    subscriptionsScreen(
                        padding = padding,
                        onSearchClick = {},
                        onCastClick = {},
                        onNotificationClick = {}
                    )
                    youScreen(
                        padding = padding,
                        onSearchClick = {},
                        onCastClick = {},
                        onNotificationClick = {},
                        onSettingClick = {},
                    )
                }
            }
        }
    }
}