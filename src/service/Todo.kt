package application.service

import application.domain.Todo
import application.repository.TodoRepository

class TodoService(private val todoRepository: TodoRepository) {
    fun findAll() = todoRepository.findAll()
    fun findById(id: Int) = todoRepository.findById(id)
    fun create(todo: Todo) = todoRepository.create(todo)
    fun update(id: Int, todo: Todo) = todoRepository.update(id, todo)
    fun delete(id: Int) = todoRepository.delete(id)
}
