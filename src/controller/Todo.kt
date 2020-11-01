package application.controller

import application.domain.Todo
import application.service.TodoService

class TodoController(private val todoService: TodoService) {
    fun findAll() = todoService.findAll()
    fun findById(id: Int) = todoService.findById(id)
    fun create(todo: Todo) = todoService.create(todo)
    fun update(id: Int, todo: Todo) = todoService.update(id, todo)
    fun delete(id: Int) = todoService.delete(id)
}
