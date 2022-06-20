package com.mpierucci.mockserver

import com.expediagroup.graphql.generator.extensions.print
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.graphQLModule() {
    val server = KtorServer()
    install(Routing)

    routing {
        post("/api/v1/graphql") {
            server.handle(this.call)
        }

        get("sdl") {
            call.respondText(graphQLSchema.print())
        }

        get("playground") {

        }
    }
}