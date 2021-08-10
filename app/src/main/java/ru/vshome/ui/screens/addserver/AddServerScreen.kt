package ru.vshome.ui.screens.addserver

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddServerScreen(model: AddServerViewModel = viewModel()) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    var isHttpsPut by remember { mutableStateOf(false) }
    val state by model.state.collectAsState()
    val isError = state is AddServerViewState.Error
    Column {
        Spacer(modifier = Modifier.weight(0.3f))
        TextField(
            value = text,
            onValueChange = {
                text = it
                model.onUrlChanged(it.text)
            },
            label = { Text("Server url") },
            placeholder = { Text("https://vshome.ru") },
            singleLine = true,
            modifier = Modifier
                .padding(16.dp, 8.dp)
                .fillMaxWidth()
                .onFocusChanged {
                    if (!isHttpsPut && it.isFocused) {
                        isHttpsPut = true
                        text = text.copy("https://", TextRange(999))
                    }
                },
            isError = isError
        )

        Text(text = state.toString(), color = MaterialTheme.colors.error)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp, 8.dp)
                .fillMaxWidth(),
            enabled = false
        ) {
            Text(text = "Save")
        }
    }
}