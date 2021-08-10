package ru.vshome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vshome.ui.screens.servers.ServersScreen
import ru.vshome.ui.theme.VSHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Themed()
        }
    }
}

@Composable
private fun Themed() {
    VSHomeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Navigation()
        }
    }
}

@Composable
private fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "servers") {
        composable("servers") { ServersScreen() }
    }
}