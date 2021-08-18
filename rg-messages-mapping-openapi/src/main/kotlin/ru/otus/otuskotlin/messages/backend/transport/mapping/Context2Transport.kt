package ru.otus.otuskotlin.messages.backend.transport.mapping

import org.example.openapi.models.CreateMessageResponse
import org.example.openapi.models.DeleteMessageResponse
import org.example.openapi.models.ReadMessageResponse
import org.example.openapi.models.UpdateMessageResponse
import ru.otus.otuskotlin.messages.backend.common.models.AppContext


fun AppContext.toReadMessageResponse() = ReadMessageResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    messageUUID = this.messageUUID,
    payload = this.messageModel?.payload,
    result = if (this.errors.isEmpty()) ReadMessageResponse.Result.SUCCESS else ReadMessageResponse.Result.ERROR
)

fun AppContext.toCreateMessageResponse() = CreateMessageResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    messageUUID = this.messageUUID,
    result = if (this.errors.isEmpty()) CreateMessageResponse.Result.SUCCESS else CreateMessageResponse.Result.ERROR
)

fun AppContext.toUpdateMessageResponse() = UpdateMessageResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    messageUUID = this.messageUUID,
    result = if (this.errors.isEmpty()) UpdateMessageResponse.Result.SUCCESS else UpdateMessageResponse.Result.ERROR
)

fun AppContext.toDeleteMessageResponse() = DeleteMessageResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    messageUUID = this.messageUUID,
    result = if (this.errors.isEmpty()) DeleteMessageResponse.Result.SUCCESS else DeleteMessageResponse.Result.ERROR
)
