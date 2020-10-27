package application

import io.ktor.application.*
import application.config.*
import application.route.setupRoutes

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    setupConfig()
    setupRoutes()
}
