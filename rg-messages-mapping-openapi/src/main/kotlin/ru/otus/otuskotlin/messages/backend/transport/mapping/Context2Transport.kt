package ru.otus.otuskotlin.messages.backend.transport.mapping

import com.messages.openapi.models.*

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

fun AppContext.toSearchMessageResponse() = SearchMessageResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    messageUUID = this.messageUUID,
    foundMessages = listOf(ResponseMessage(this.messageModel?.payload)),
    result = if (this.errors.isEmpty()) SearchMessageResponse.Result.SUCCESS else SearchMessageResponse.Result.ERROR
)
