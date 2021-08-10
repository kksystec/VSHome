package ru.vshome.server.web

import io.ktor.application.Application
import io.ktor.routing.Routing
import io.ktor.routing.routing

interface KtorRoutingConfiguration : KtorApplicationConfiguration {
    override fun applicationPriority(): Int = KtorApplicationConfiguration.PRIORITY_LOW

    override fun Application.configure() {
        routing { configure() }
    }

    fun Routing.configure()
}
