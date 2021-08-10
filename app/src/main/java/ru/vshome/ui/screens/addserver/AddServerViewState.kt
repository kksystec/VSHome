package ru.vshome.ui.screens.addserver

sealed class AddServerViewState {
    object NoError : AddServerViewState()
    data class UrlParseError(val text: String) : AddServerViewState()
}