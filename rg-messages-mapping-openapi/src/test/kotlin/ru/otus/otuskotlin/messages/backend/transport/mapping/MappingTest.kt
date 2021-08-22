package ru.otus.otuskotlin.messages.backend.transport.mapping


import com.messages.openapi.models.*
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import ru.otus.otuskotlin.messages.backend.common.models.MessageModel
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class MappingTest {
    @Test
    fun createMappingTest(){
        val messageUUID = UUID.randomUUID()
        val fromUUID = UUID.randomUUID()
        val toUUID = UUID.randomUUID()
        val payloadValue = "payload"

        val createMessageRequest = CreateMessageRequest(
            payload = payloadValue,
            messageUUID = messageUUID,
            from = fromUUID,
            to = toUUID
        )
        val appContext = AppContext().setQuery(createMessageRequest)
        assertEquals(appContext.messageModel?.payload,payloadValue)
        assertEquals(appContext.messageModel?.from,fromUUID)
        assertEquals(appContext.messageModel?.to,toUUID)

    }
    @Test
    fun createMappingResponseTest(){
        val messageUUID = UUID.randomUUID()
        val fromUUID = UUID.randomUUID()
        val toUUID = UUID.randomUUID()
        val requestUUID = UUID.randomUUID()
        val payloadValue = "payload"
        val appContext = AppContext(
            messageModel = MessageModel(
                uuid = messageUUID,
                from = fromUUID,
                to = toUUID,
                payload = payloadValue
            ),
            messageUUID = messageUUID,
            requestUUID = requestUUID,
            errors = mutableListOf(RequestError("123","456"))
        )

        val createMessageResponse = appContext.toCreateMessageResponse()

        assertEquals(createMessageResponse.messageUUID,messageUUID)
        assertEquals(createMessageResponse.requestUUID,requestUUID)
        assertEquals(createMessageResponse.result,CreateMessageResponse.Result.ERROR)
    }
}