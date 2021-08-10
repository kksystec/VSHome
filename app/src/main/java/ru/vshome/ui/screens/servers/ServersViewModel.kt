package ru.vshome.ui.screens.servers

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ServersViewModel : ViewModel() {
    val state = MutableStateFlow(ServersViewState(sequence {
        repeat(20) {
            yield(ServersViewState.ServerUiModel("Server $it", "127.0.0.1:8080"))
        }
    }.toList()))
}