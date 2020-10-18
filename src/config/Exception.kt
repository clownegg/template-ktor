package application.config

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.exceptionConfig() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) {
            call.respond("not resource found")
        }
    }
}
