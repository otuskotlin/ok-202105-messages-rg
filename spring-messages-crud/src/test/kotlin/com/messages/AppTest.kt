package com.messages


import com.messages.controller.AppController
import com.messages.openapi.models.CreateMessageRequest
import com.messages.openapi.models.DeleteMessageRequest
import com.messages.openapi.models.UpdateMessageRequest
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
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.*

@RunWith(SpringRunner::class)
@Testcontainers
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
            withUsername("keycloak")
            withPassword("password")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl);
            registry.add("spring.datasource.password", container::getPassword);
            registry.add("spring.datasource.username", container::getUsername);
            registry.add("spring.flyway.url", container::getJdbcUrl);
        }
    }
    @Test
    @Transactional
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

        Assertions.assertEquals(appRepository.findAll().size,1)
    }

    @Test
    @Transactional
    fun testUpdate() {
        val createMessageRequest = CreateMessageRequest(
            payload = "payload",
            from = UUID_ZERO,
            to = UUID_ZERO,
            messageUUID = UUID_ZERO,
            messageType = "CreateMessageRequest",
            parentUuid = UUID_ZERO
        )
        appController.createMessage(createMessageRequest)
        val findAll = appRepository.findAll()

        Assertions.assertEquals(findAll.first().payload,"payload")
        val updateMessageRequest = UpdateMessageRequest(
            payload = "payloadUpdated",
            messageUUID = findAll.first().id?:throw Exception("wrong uuid"),
            messageType = "UpdateMessageRequest",
        )
        appController.updateMessage(updateMessageRequest)
        val findAllUpdated = appRepository.findAll()

        Assertions.assertEquals(findAllUpdated.first().payload,"payloadUpdated")
    }

    @Test
    fun testDelete() {
        val createMessageRequest = CreateMessageRequest(
            payload = "payload",
            from = UUID_ZERO,
            to = UUID_ZERO,
            messageUUID = UUID_ZERO,
            messageType = "CreateMessageRequest",
            parentUuid = UUID_ZERO
        )
        appController.createMessage(createMessageRequest)
        val findAll = appRepository.findAll()
        val first = findAll.first()

        Assertions.assertEquals(first.payload,"payload")
        appController.deleteMessage(DeleteMessageRequest(
            messageUUID = first.id?:throw Exception("wrong uuid"),
            messageType = "DeleteMessageRequest"
        ))
        val updatedFindAll = appRepository.findAll()

        Assertions.assertEquals(updatedFindAll.size,0)
    }

}