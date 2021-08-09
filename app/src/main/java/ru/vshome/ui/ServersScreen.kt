package ru.vshome.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ServersScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        }
    ) {
        ServersList()
    }
}

@Composable
private fun ServersList() {
    LazyColumn {
        items(20) { i ->
            ServerItem(ServerUiModel("Server $i", "127.0.0.1:8080"))
        }
    }
}

@Composable
private fun ServerItem(server: ServerUiModel) {
    Card(
        Modifier
            .padding(4.dp, 2.dp)
            .fillMaxWidth()
    ) {
        Text(text = server.name, Modifier.padding(16.dp, 8.dp))
    }
}

data class ServerUiModel(
    val name: String,
    val address: String
)