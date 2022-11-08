package org.jetbrains.sample

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual object HostMachine {
    actual val platformType: String = "native"
    actual val httpClientEngine: HttpClientEngineFactory<*> = Darwin

}