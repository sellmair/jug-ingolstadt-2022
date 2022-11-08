package org.jetbrains.sample

import io.ktor.client.engine.*

expect object HostMachine {
    val platformType: String
    val httpClientEngine: HttpClientEngineFactory<*>
}