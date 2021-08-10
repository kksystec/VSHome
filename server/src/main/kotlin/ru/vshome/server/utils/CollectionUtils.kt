package ru.vshome.server.utils

inline fun <T> Iterable<T>.forEachApply(block: T.() -> Unit) {
    forEach { block(it) }
}
