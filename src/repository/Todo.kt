package application.repository

import application.dto.TodoDTO

class TodoRepository(private val todoDTO: TodoDTO) {
    fun findAll() = todoDTO.findAll()
}