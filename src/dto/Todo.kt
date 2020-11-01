package application.dto

import application.domain.Todo
import application.entity.TodoEntity
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class TodoDTO {
    fun findAll() = transaction {
        val query = TodoEntity.selectAll()
            .andWhere { TodoEntity.isEnabled eq true }
            .andWhere { TodoEntity.isDeleted eq false }
        query.map {
            Todo(
                id = it[TodoEntity.id],
                title = it[TodoEntity.title],
                done = it[TodoEntity.done],
                isEnabled = it[TodoEntity.isEnabled],
                isDeleted = it[TodoEntity.isDeleted]
            )
        }
    }
}
