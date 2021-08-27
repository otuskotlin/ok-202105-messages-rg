package com.support.controller

import com.messages.support.openapi.models.*
import com.support.service.SupportService
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.registerSupportRoute(supportService: SupportService) {

    route("/support") {
        post("/create") {
            val support = call.receive<CreateSupportRequest>()
            call.respond(supportService.createSupport(support))
        }
        put("/update") {
            val support = call.receive<UpdateSupportRequest>()
            supportService.updateSupport(support)
        }
        delete("/delete") {
            val support = call.receive<DeleteSupportRequest>()
            supportService.deleteSupport(support)
        }
        post("/search") {
            //TODO not implemented
        }
        post("/read") {
            val support = call.receive<ReadSupportRequest>()
            supportService.readSupport(support)
        }
    }
}
