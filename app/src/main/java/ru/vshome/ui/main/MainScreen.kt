package ru.vshome.ui.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import ru.vshome.ui.Navigation
import ru.vshome.ui.theme.VSHomeTheme

@Composable
fun MainScreen() {
    Themed()
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

