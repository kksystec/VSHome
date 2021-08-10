package ru.vshome.server.web

import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.ApplicationEngineEnvironment
import io.ktor.server.engine.ApplicationEngineEnvironmentBuilder
import io.ktor.server.engine.addShutdownHook
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import org.slf4j.LoggerFactory
import ru.vshome.server.utils.forEachApply
import ru.vshome.server.utils.measureAndLog
import ru.vshome.server.utils.withName

interface WebServer {
    suspend fun start()
}

private const val SERVER_SHUTDOWN_THRESHOLD_MS = 3000L

class WebServerImpl(
    private val configurations: List<KtorApplicationConfiguration>,
    private val environmentConfigurations: List<KtorApplicationEnvironmentConfiguration>,
) : WebServer {
    private val logger = LoggerFactory.getLogger("web-server")
    override suspend fun start() = withName("server-start") {
        logger.info("starting")

        val environment = createEnvironment()
        val embeddedServer = createEmbeddedServer(environment)
        runEmbeddedServer(embeddedServer)
    }

    private suspend fun runEmbeddedServer(embeddedServer: ApplicationEngine) {
        suspendCancellableCoroutine<Unit> {
            it.invokeOnCancellation {
                logger.debug("coroutine canceled, stopping server")
                embeddedServer.stop(SERVER_SHUTDOWN_THRESHOLD_MS, SERVER_SHUTDOWN_THRESHOLD_MS)
            }
            embeddedServer.addShutdownHook {
                logger.debug("invoke shutdown hook")
                it.resume(Unit)
            }
            measureAndLog(logger, "starting embedded server") {
                embeddedServer.start()
            }
        }
    }

    private fun createEmbeddedServer(environment: ApplicationEngineEnvironment): ApplicationEngine =
        measureAndLog(logger, "creating server instance") { embeddedServer(Netty, environment) }

    private fun createEnvironment(): ApplicationEngineEnvironment = measureAndLog(logger, "creating environment") {
        applicationEngineEnvironment {
            applyEnvironmentConfigurations()
            registerConfigurations()
        }
    }

    private fun ApplicationEngineEnvironmentBuilder.applyEnvironmentConfigurations() {
        measureAndLog(logger, "applying environment configurations") {
            environmentConfigurations.sortedByDescending { it.applicationEngineEnvironmentPriority() }
                .forEachApply conf@{
                    measureAndLog(logger, "applying environment configuration: ${this@conf.javaClass.simpleName}") {
                        runCatching { configure() }
                            .onFailure {
                                throw ServerConfigurationException.ApplyingEnvironmentConfigurationException(
                                    "Failed to apply environment configuration ${this@conf.javaClass.simpleName}", it
                                )
                            }
                    }
                }
        }
    }

    private fun ApplicationEngineEnvironmentBuilder.registerConfigurations() {
        measureAndLog(logger, "register configurations") {
            configurations.sortedByDescending { it.applicationPriority() }.forEachApply conf@{
                module {
                    measureAndLog(logger, "applying configuration: ${this@conf.javaClass.simpleName}") {
                        runCatching { configure() }
                            .onFailure {
                                throw ServerConfigurationException.ApplyingConfigurationException(
                                    "Failed to apply configuration ${this@conf.javaClass.simpleName}", it
                                )
                            }
                    }
                }
            }
        }
    }
}

sealed class ServerConfigurationException(message: String, cause: Throwable) : RuntimeException(message, cause) {
    class ApplyingEnvironmentConfigurationException(message: String, cause: Throwable) :
        ServerConfigurationException(message, cause)

    class ApplyingConfigurationException(message: String, cause: Throwable) :
        ServerConfigurationException(message, cause)
}
