package ru.vshome.server.utils

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> withIODispatcher(block: suspend CoroutineScope.() -> T) = withContext(Dispatchers.IO, block)
suspend fun <T> withName(name: String, block: suspend CoroutineScope.() -> T) = withContext(CoroutineName(name), block)
