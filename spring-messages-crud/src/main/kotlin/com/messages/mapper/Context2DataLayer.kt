package com.messages.mapper

import com.messages.models.Message
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import java.util.*

fun AppContext.toMessageRecord(): Message {
    return Message(
        id = this.messageModel?.uuid,
        parentUuid = this.messageModel?.parentUuid?: UUID(0,0),
        from = this.messageModel?.from,
        to = this.messageModel?.to,
        payload = this.messageModel?.payload,
        updated = this.messageModel?.updated
    )
}