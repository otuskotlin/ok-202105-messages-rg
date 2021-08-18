package ru.otus.otuskotlin.messages.backend.transport.mapping

import org.example.openapi.models.CreateMessageRequest
import org.example.openapi.models.DeleteMessageRequest
import org.example.openapi.models.ReadMessageRequest
import org.example.openapi.models.UpdateMessageRequest
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import ru.otus.otuskotlin.messages.backend.common.models.MessageModel
import java.time.OffsetDateTime
import java.util.*


fun AppContext.setQuery(query: CreateMessageRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
    messageModel = query.toModel()
}

fun AppContext.setQuery(query: ReadMessageRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
    messageUUID = query.messageUUID
}

fun AppContext.setQuery(query: UpdateMessageRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
    messageUUID = query.messageUUID
    messageModel = query.toModel()
}

fun AppContext.setQuery(query: DeleteMessageRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
    messageUUID = query.messageUUID
}

private fun CreateMessageRequest.toModel() = MessageModel(
    uuid = UUID.randomUUID(),
    updated = OffsetDateTime.now(),
    created = OffsetDateTime.now(),
    parentUuid = this.parentUuid,
    title = "Created Message",
    payload = this.payload,
    from = this.from,
    to = this.to
)

private fun UpdateMessageRequest.toModel() = MessageModel(
    uuid = this.messageUUID,
    updated = OffsetDateTime.now(),
    parentUuid = null,
    title = "Updated Message",
    payload = this.payload,
    from = null,
    to = null,
    created = null
)
