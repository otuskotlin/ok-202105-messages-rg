package com.customers.controller

import com.customers.mappers.setCommand
import com.customers.model.CustomerContext
import com.customers.service.CustomerService
import com.messages.openapi.models.CustomerCommandRequest
import com.messages.openapi.models.CustomerCommandResponse
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    private val service: CustomerService
) {
    @PostMapping
    fun create(@RequestBody req: CustomerCommandRequest) {
        val context = CustomerContext()
        context.setCommand(req)
        service.create(context)
    }

    @GetMapping
    fun read(req: CustomerCommandRequest): CustomerCommandResponse {
        val context = CustomerContext()
        context.setCommand(req)
        return service.read(context)
    }

    @PutMapping
    fun update(req: CustomerCommandRequest) {
        val context = CustomerContext()
        context.setCommand(req)
        service.update(context)
    }

    @DeleteMapping("/{uuid}")
    fun delete(@PathVariable uuid: UUID) {
        service.delete(uuid)
    }

    @PostMapping("/search")
    fun search(req: CustomerCommandRequest) {
        val context = CustomerContext()
        context.setCommand(req)
        service.search(context)
    }
}