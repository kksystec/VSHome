package ru.vshome.ui.screens.servers

data class ServersViewState(
    val servers: List<ServerUiModel>
) {
    data class ServerUiModel(
        val name: String,
        val address: String
    )
}