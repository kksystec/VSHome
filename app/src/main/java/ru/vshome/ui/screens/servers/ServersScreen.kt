package ru.vshome.ui.screens.servers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ServersScreen(model: ServersViewModel = viewModel()) {
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
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text(text = server.name)
            Spacer(Modifier.width(8.dp))
            Text(text = server.address)
        }
    }
}

data class ServerUiModel(
    val name: String,
    val address: String
)