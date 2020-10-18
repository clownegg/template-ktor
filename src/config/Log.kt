package application.config

import io.ktor.request.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.application.*

fun Application.logConfig() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}
