package application.controller

import application.vo.TodoVO

class TodoController {
    fun findAll() = listOf<TodoVO>(
            TodoVO(1, "test", false)
    )
}
