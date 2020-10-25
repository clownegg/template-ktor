package application.config

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

fun Application.databaseConfig() {
    val url = environment.config.property("ktor.database.url").getString()
    val user = environment.config.property("ktor.database.user").getString()
    val password = environment.config.property("ktor.database.password").getString()

    Database.connect(url = url, driver = "com.mysql.cj.jdbc.Driver", user = user, password = password)
}
