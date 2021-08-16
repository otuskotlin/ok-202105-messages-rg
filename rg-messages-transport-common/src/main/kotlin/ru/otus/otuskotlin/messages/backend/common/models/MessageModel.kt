package ru.otus.otuskotlin.messages.backend.common.models

import java.time.OffsetDateTime
import java.util.*

data class MessageModel(
    val uuid: UUID,
    val parentUuid: UUID,
    val title: String,
    val payload: String,
    val from: UUID,
    val to: UUID,
    val created:OffsetDateTime,
    val updated:OffsetDateTime,

)