package application.di

import application.controller.TodoController
import application.dto.TodoDTO
import application.repository.TodoRepository
import application.service.TodoService
import org.koin.dsl.module

val todoModule = module {
    single { TodoController(get()) }
    single { TodoService(get()) }
    single { TodoRepository(get()) }
    single { TodoDTO() }
}
