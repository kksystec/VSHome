package ru.vshome.ui.screens.addserver

sealed class AddServerViewState {
    object NoError : AddServerViewState()
    abstract class Error : AddServerViewState()
    data class UrlParseError(val text: String) : Error()
}