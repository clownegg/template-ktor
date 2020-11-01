package application.route

import application.controller.TodoController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.todoRoutes() {
    route("/todos") {
        val todoController: TodoController by inject()
        get("/") {
            call.respond(todoController.findAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            call.respond(todoController.findById(id))
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
