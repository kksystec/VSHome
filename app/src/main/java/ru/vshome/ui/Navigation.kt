package ru.vshome.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vshome.ui.screens.addserver.AddServerScreen
import ru.vshome.ui.screens.servers.ServersScreen


enum class Screens(
    val route: String,
    private val content: @Composable (NavBackStackEntry) -> Unit
) {
    Servers("servers", { ServersScreen() }),
    AddServer("add_servers", { AddServerScreen() })

    ;

    fun NavGraphBuilder.composableScreen() {
        composable(this@Screens.route, content = this@Screens.content)
    }
}

val LocalNavigation = staticCompositionLocalOf<NavController> {
    error("No local provider for LocalNavigation")
}

fun NavController.navigate(screen: Screens) {
    navigate(screen.route)
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalNavigation provides navController
    ) {
        NavHost(navController = navController, startDestination = Screens.Servers)
    }
}

@Composable
private fun NavHost(
    navController: NavHostController,
    startDestination: Screens,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController,
        startDestination.route,
        modifier = modifier
    ) {
        Screens.values().forEach { it.apply { composableScreen() } }
    }
}

