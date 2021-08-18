package ru.otus.otuskotlin.messages.backend.common.models

import org.example.openapi.models.RequestError
import java.util.*

data class AppContext(
    var errors: MutableList<RequestError> = mutableListOf(),
    var messageModel: MessageModel?=null,
    var messageUUID: UUID?=null,
    var requestUUID: UUID?=null
) {

}