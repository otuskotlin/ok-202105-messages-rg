package ru.otus.otuskotlin.messages.backend.common.models

import java.time.OffsetDateTime
import java.util.*

data class MessageModel(
    val uuid: UUID,
    val parentUuid: UUID?=null,
    val title: String?=null,
    val payload: String,
    val from: UUID?,
    val to: UUID?,
    val created:OffsetDateTime?= OffsetDateTime.now(),
    val updated:OffsetDateTime?= OffsetDateTime.now()

    )