package ru.vshome.server

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking
import org.apache.logging.log4j.LogManager
import org.slf4j.LoggerFactory


@Suppress("TooGenericExceptionCaught")
fun main() {
//    Kodein.direct.instance<DebugInteractor>().setup()
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
