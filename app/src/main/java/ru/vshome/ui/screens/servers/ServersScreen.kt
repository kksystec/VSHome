package ru.vshome.ui.screens.servers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ServersScreen(model: ServersViewModel = viewModel()) {
    val state = model.state.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        }
    ) {
        ServersList(state.servers)
    }
}

@Composable
private fun ServersList(servers: List<ServersViewState.ServerUiModel>) {
    LazyColumn {
        items(servers) { ServerItem(it) }
    }
}

@Composable
private fun ServerItem(server: ServersViewState.ServerUiModel) {
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
