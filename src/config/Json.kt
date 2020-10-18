package application.config

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.jackson.*

fun Application.jsonConfig() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}
