package com.sanmer.mrepo.ui.activity.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.sanmer.mrepo.ui.navigation.BottomNav
import com.sanmer.mrepo.ui.navigation.MainGraph
import com.sanmer.mrepo.ui.navigation.graph.homeGraph
import com.sanmer.mrepo.ui.navigation.graph.modulesGraph
import com.sanmer.mrepo.ui.navigation.graph.settingsGraph

@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        bottomBar = {
            BottomNav(
                navController = navController
            )
        },
    ) {
        AnimatedNavHost(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding()),
            navController = navController,
            startDestination = MainGraph.Home.route,
            enterTransition = { fadeIn(animationSpec = tween(400)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            homeGraph(
                navController = navController
            )
            modulesGraph(
                navController = navController
            )
            settingsGraph(
                navController = navController
            )
        }
    }
}