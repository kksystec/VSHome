package ru.vshome.server.web

import io.ktor.application.Application

interface KtorApplicationConfiguration {
    fun applicationPriority(): Int = PRIORITY_DEFAULT
    fun Application.configure()

    companion object {
        const val PRIORITY_HIGHEST = 999
        const val PRIORITY_HIGH = 100
        const val PRIORITY_DEFAULT = 0
        const val PRIORITY_LOW = -100
        const val PRIORITY_LOWEST = -999
    }
}
