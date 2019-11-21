package htnk128.kotlin.ktor.sample

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondRedirect("hello")
        }
        get("/hello") {
            call.respondText(
                """
                    |{
                    |  "message": "hello ktor!"
                    |}
                    """
                    .trimMargin(),
                ContentType.Application.Json
            )
        }
    }
}

