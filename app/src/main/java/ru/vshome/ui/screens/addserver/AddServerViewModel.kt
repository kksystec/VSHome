package ru.vshome.ui.screens.addserver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.net.URL

class AddServerViewModel : ViewModel() {
    val state = MutableStateFlow<AddServerViewState>(AddServerViewState.NoError)

    fun onUrlChanged(urlString: String) {
        viewModelScope.launch {
            runCatching {
                val url = URL(urlString)
                assert(url.protocol == "https") { "Wrong protocol" }
                assert(url.host.isNotEmpty()) { "Wrong host" }
                assert(url.path.isEmpty() || url.path == "/") { "Wrong path" }

            }
                .onSuccess { state.emit(AddServerViewState.NoError) }
                .onFailure { state.emit(AddServerViewState.UrlParseError(it.message ?: "null")) }
        }
    }
}