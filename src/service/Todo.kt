package application.service

import application.repository.TodoRepository

class TodoService(private val todoRepository: TodoRepository) {
    fun findAll() = todoRepository.findAll()
    fun findById(id: Int) = todoRepository.findById(id)
}
