package com.messages

import com.messages.openapi.models.CreateMessageRequest
import com.messages.service.AppService
import org.junit.Test


import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [Application::class])
class AppTest {

    @Autowired
    private lateinit var appService: AppService
    @Test
    fun testAppService(){
        val messageUUID = UUID.randomUUID()

        val createMessageRequest = CreateMessageRequest("pay",
            UUID.randomUUID(),
            UUID.randomUUID(),
            messageUUID = messageUUID
        )

        val createHandler = appService.createHandler(createMessageRequest)
        assertEquals(createHandler.messageUUID,messageUUID)
    }

}