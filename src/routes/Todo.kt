package application.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.todoRoutes() {
    route("/todos") {
        get("/") {
            call.respond("todo All")
        }

        get("/{id}") {
            call.respond("todo one")
        }

        post("/") {
            call.respond("todo create")
        }

        put("/{id}") {
            call.respond("todo update")
        }

        delete("/{id}") {
            call.respond("todo delete")
        }
    }
}
