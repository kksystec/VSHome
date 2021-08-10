package ru.vshome.server.utils

import kotlin.system.measureTimeMillis
import org.slf4j.Logger

inline fun <T> measureAndLog(logger: Logger, message: String, block: () -> T): T {
    logger.debug(message)
    val result: T
    val time = measureTimeMillis { result = block() }
    logger.debug("$message. Done at $time ms")
    return result
}
