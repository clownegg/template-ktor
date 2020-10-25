package application.config

import io.ktor.application.*

fun Application.setupConfig() {
    corsConfig()
    logConfig()
    jsonConfig()
    exceptionConfig()
    databaseConfig()
}
