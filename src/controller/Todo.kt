package application.controller

import application.service.TodoService

class TodoController(private val todoService: TodoService) {
    fun findAll() = todoService.findAll()
    fun findById(id: Int) = todoService.findById(id)
}
