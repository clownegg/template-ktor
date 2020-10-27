package application.config

import application.di.todoModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.koinConfig() {
    install(Koin) {
        modules(todoModule)
    }
}