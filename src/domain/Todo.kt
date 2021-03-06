package application.domain

data class Todo(
    var id: Int? = null,
    var title: String,
    var done: Boolean = false,
    var isEnabled: Boolean = true,
    var isDeleted: Boolean = false,
    var createdAt: String? = null,
    var updatedAt: String? = null
)
