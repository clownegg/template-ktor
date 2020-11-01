package application.route

import application.controller.TodoController
import application.domain.Todo
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
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
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null)
                call.respond(HttpStatusCode.BadRequest)
            else
                call.respond(todoController.findById(id))
        }

        post("/") {
            val body = call.receive<Todo>()
            call.respond(todoController.create(body))
        }

        put("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val body = call.receive<Todo>()
            if (id == null)
                call.respond(HttpStatusCode.BadRequest)
            else
                call.respond(todoController.update(id, body))
        }

        delete("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null)
                call.respond(HttpStatusCode.BadRequest)
            else
                call.respond(todoController.delete(id))
        }
    }
}
