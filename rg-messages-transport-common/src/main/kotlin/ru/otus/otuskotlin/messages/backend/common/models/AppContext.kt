package ru.otus.otuskotlin.messages.backend.common.models

import java.util.*

data class AppContext(var messageModel: MessageModel,
                      var messageUUID: UUID,
                      var requestUUID: UUID
) {


}