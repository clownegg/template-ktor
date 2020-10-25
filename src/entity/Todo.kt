package application.entity

import org.jetbrains.exposed.sql.Table

object Todo : Table("t_todos") {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 255)
    val done = bool("done")
    val isEnabled = bool("is_enabled").default(true)
    val isDeleted = bool("is_deleted").default(false)
}
