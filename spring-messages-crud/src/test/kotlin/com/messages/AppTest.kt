package com.messages


import com.messages.controller.AppController
import com.messages.openapi.models.CreateMessageRequest
import com.messages.repository.AppRepository

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [Application::class])
class AppTest {
    val UUID_ZERO = UUID(0, 0)

    @Autowired
    private lateinit var appController: AppController

    @Autowired
    private lateinit var appRepository: AppRepository

    companion object {

        @Container
        val container = PostgreSQLContainer<Nothing>("postgres:12").apply {
            withDatabaseName("testdb")
            withUsername("admin")
            withPassword("123456")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl);
            registry.add("spring.datasource.password", container::getPassword);
            registry.add("spring.datasource.username", container::getUsername);
        }
    }
    @Test
    fun testCreate() {
        val createMessageRequest = CreateMessageRequest(
            payload = "payload",
            from = UUID_ZERO,
            to = UUID_ZERO,
            messageUUID = UUID_ZERO,
            messageType = "CreateMessageRequest",
            parentUuid = UUID_ZERO
        )
        appController.createMessage(createMessageRequest)
        Assertions.assertEquals(appRepository.getById(UUID_ZERO).payload,"payload")
    }

    @Test
    fun testUpdate() {

    }

    @Test
    fun testDelete() {

    }

}