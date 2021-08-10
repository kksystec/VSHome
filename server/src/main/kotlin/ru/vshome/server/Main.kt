package ru.vshome.server

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking
import org.apache.logging.log4j.LogManager
import org.kodein.di.direct
import org.kodein.di.instance
import org.slf4j.LoggerFactory
import ru.vshome.server.domain.DebugInteractor


@Suppress("TooGenericExceptionCaught")
fun main() {
§§    // Don't use coroutines before DebugInteractor was setup
    Kodein.direct.instance<DebugInteractor>().setup()

    runBlocking(CoroutineName("main")) {
        val logger = LoggerFactory.getLogger("server")
        logger.info("starting")
        try {
//            Kodein.direct.instance<WebServer>().start()
            logger.info("all work done, server stopped")
        } catch (e: Exception) {
            logger.error("Fatal exception: ${e.message}", e)
        } finally {
            logger.debug("Closing logger")
            LogManager.shutdown()
        }
    }
}
