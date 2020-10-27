package application.route

import io.ktor.application.*
import io.ktor.routing.*

fun Application.setupRoutes() {
    routing {
        todoRoutes()
    }
}
