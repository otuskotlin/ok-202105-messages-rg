package com

import com.customers.Application
import com.customers.controller.CustomerController
import com.customers.mappers.setCommand
import com.customers.model.CustomerContext
import com.customers.repository.impl.CustomerRepositoryInMemory
import com.customers.service.CustomerService
import com.messages.openapi.models.CustomerCommandRequest
import org.junit.jupiter.api.Assertions
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@EnableAutoConfiguration
@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApp {

    @Autowired
    lateinit var controller: CustomerController
    @Autowired
    lateinit var customerRepositoryInMemory: CustomerRepositoryInMemory

    @Test
    fun testCreate(){
        val uuid = UUID.randomUUID()
        val req = CustomerCommandRequest(
            id = uuid,
            name = "asd",
            password = "asdf",
            email = "asdf"
        )
        controller.create(req)
        Assertions.assertEquals(customerRepositoryInMemory.size(),1)
    }
    @Test
    fun testUpdate(){
        val uuid = UUID.randomUUID()
        val req = CustomerCommandRequest(
            id = uuid,
            name = "asd",
            password = "asdf",
            email = "asdf"
        )
        controller.create(req)
        Assertions.assertEquals(controller.read(req).email,"asdf")
        val req2 = CustomerCommandRequest(
            id = uuid,
            name = "asd",
            password = "asdf",
            email = "fdsa"
        )
        controller.update(req2)
        Assertions.assertEquals(controller.read(req).email,"fdsa")
    }
    @Test
    fun testDelete(){
        val uuid = UUID.randomUUID()
        val req = CustomerCommandRequest(
            id = uuid,
            name = "asd",
            password = "asdf",
            email = "asdf"
        )
        controller.create(req)
        Assertions.assertEquals(controller.read(req).email,"asdf")
        req.id?.let { controller.delete(it) }
        Assertions.assertEquals(customerRepositoryInMemory.size(),0)
    }
}