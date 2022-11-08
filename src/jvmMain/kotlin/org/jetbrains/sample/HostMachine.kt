package org.jetbrains.sample

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual object HostMachine {
    actual val platformType: String = "jvm"
    actual val httpClientEngine: HttpClientEngineFactory<*> = OkHttp
}