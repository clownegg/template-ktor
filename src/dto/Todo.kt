package application.dto

import application.domain.Todo
import application.entity.TodoEntity
import io.ktor.features.*
import org.jetbrains.exposed.sql.*
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

    fun findById(id: Int) = transaction {
        val query = TodoEntity
            .select { TodoEntity.id eq id }
            .andWhere { TodoEntity.isEnabled eq true }
            .andWhere { TodoEntity.isDeleted eq false }
            .singleOrNull()
            ?: throw NotFoundException()
        Todo(
            id = query[TodoEntity.id],
            title = query[TodoEntity.title],
            done = query[TodoEntity.done],
            isEnabled = query[TodoEntity.isEnabled],
            isDeleted = query[TodoEntity.isDeleted]
        )
    }

    fun create(todo: Todo) = transaction {
        val query = TodoEntity.insertIgnore {
            it[title] = todo.title
            it[done] = todo.done
        }
        Todo(
            id = query[TodoEntity.id],
            title = query[TodoEntity.title],
            done = query[TodoEntity.done],
            isEnabled = query[TodoEntity.isEnabled],
            isDeleted = query[TodoEntity.isDeleted]
        )
    }

    fun update(id: Int, todo: Todo) = transaction {
        TodoEntity.update({ TodoEntity.id eq id }) {
            it[title] = todo.title
            it[done] = todo.done
        }
        findById(id)
    }

    fun delete(id: Int) = transaction {
        TodoEntity.deleteIgnoreWhere {
            TodoEntity.id eq id and (TodoEntity.isEnabled eq true) and (TodoEntity.isDeleted eq false)
        }
    }
}
