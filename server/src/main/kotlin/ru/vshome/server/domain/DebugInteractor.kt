package ru.vshome.server.domain

interface DebugInteractor {
    fun setup()
}

class DebugInteractorImpl(
) : DebugInteractor {
    override fun setup() {
        System.setProperty("kotlinx.coroutines.debug", "on")
    }
}
