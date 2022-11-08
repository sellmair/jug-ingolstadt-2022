package org.jetbrains.sample

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() {
    println("This is running on ${HostMachine.platformType}")
    runBlocking {
        println("The joke is: ${getJoke()}")
    }
}

suspend fun getJoke(): String {
    return HttpClient(HostMachine.httpClientEngine).use {
        it.get("https://api.chucknorris.io/jokes/random").bodyAsText()
    }
}

fun getJokeSync(): String {
    return runBlocking(Dispatchers.Default) {
        getJoke()
    }
}