package com.messages.mapper

import com.messages.models.Message
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import ru.otus.otuskotlin.messages.backend.common.models.MessageModel

fun AppContext.setMessageRecord(message: Message) {
    messageModel = MessageModel(
        uuid = message.id ?: throw Exception("wrong uuid"),
        parentUuid = message.parentUuid,
        payload = message.payload ?: throw Exception("wrong payload"),
        from = message.from,
        to = message.to,
        created = message.created,
        updated = message.updated
    )
}