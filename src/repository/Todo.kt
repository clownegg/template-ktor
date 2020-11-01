package application.repository

import application.domain.Todo
import application.dto.TodoDTO

class TodoRepository(private val todoDTO: TodoDTO) {
    fun findAll() = todoDTO.findAll()
    fun findById(id: Int) = todoDTO.findById(id)
    fun create(todo: Todo) = todoDTO.create(todo)
    fun update(id: Int, todo: Todo) = todoDTO.update(id, todo)
    fun delete(id: Int) = todoDTO.delete(id)
}
