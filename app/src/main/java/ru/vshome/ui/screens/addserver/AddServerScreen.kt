package ru.vshome.ui.screens.addserver

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddServerScreen(model: AddServerViewModel = viewModel()) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    var isHttpsPut by remember { mutableStateOf(false) }
    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
                model.onUrlChanged(it.text)
            },
            label = { Text("URL") },
            placeholder = { Text("https://vshome.ru") },
            singleLine = true,
            modifier = Modifier.onFocusChanged {
                if (!isHttpsPut && it.isFocused) {
                    isHttpsPut = true
                    text = text.copy("https://", TextRange(999))
                }
            }
        )

        val state by model.state.collectAsState()
        Text(text = state.toString())
    }
}