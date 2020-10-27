package application.di

import application.controller.TodoController
import org.koin.dsl.module

val todoModule = module {
    single { TodoController()}
}
