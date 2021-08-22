package com.messages.service

import com.messages.openapi.models.*

import org.springframework.stereotype.Service
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import ru.otus.otuskotlin.messages.backend.transport.mapping.*


@Service
class AppService {

    fun createHandler(createMessageRequest: CreateMessageRequest): CreateMessageResponse {
        return AppContext().setQuery(createMessageRequest).toCreateMessageResponse()
    }

    fun updateHandler(updateMessageRequest: ReadMessageRequest): UpdateMessageResponse {
        return AppContext().setQuery(updateMessageRequest).toUpdateMessageResponse()
    }

    fun deleteHandler(deleteMessageRequest: DeleteMessageRequest): DeleteMessageResponse {
        return AppContext().setQuery(deleteMessageRequest).toDeleteMessageResponse()
    }

    fun searchHandler(searchMessageRequest: SearchMessageRequest): SearchMessageResponse {
        return AppContext().setQuery(searchMessageRequest).toSearchMessageResponse()
    }

    fun readHandler(readMessageRequest: ReadMessageRequest): ReadMessageResponse {
        return AppContext().setQuery(readMessageRequest).toReadMessageResponse()
    }

}