package com.messages.service

import com.messages.mapper.setMessageRecord
import com.messages.mapper.toMessageRecord
import com.messages.openapi.models.*
import com.messages.repository.AppRepository

import org.springframework.stereotype.Service
import ru.otus.otuskotlin.messages.backend.common.models.AppContext
import ru.otus.otuskotlin.messages.backend.transport.mapping.*


@Service
class AppService(
    var appRepository: AppRepository
) {

    fun createHandler(createMessageRequest: CreateMessageRequest): CreateMessageResponse {
        val context = AppContext()
        context.setQuery(createMessageRequest)
        appRepository.save(context.toMessageRecord())
        return context.toCreateMessageResponse()
    }

    fun updateHandler(updateMessageRequest: ReadMessageRequest): UpdateMessageResponse {
        val context = AppContext()
        context.setQuery(updateMessageRequest)
        appRepository.save(context.toMessageRecord())
        return context.toUpdateMessageResponse()
    }

    fun deleteHandler(deleteMessageRequest: DeleteMessageRequest): DeleteMessageResponse {
        val appContext = AppContext()
        appContext.setQuery(deleteMessageRequest)
        appRepository.deleteById(appContext.messageModel?.uuid?:throw Exception("wrong messageUuid"))
        return appContext.toDeleteMessageResponse()
    }

    fun searchHandler(searchMessageRequest: SearchMessageRequest): SearchMessageResponse {
        val context = AppContext()
        val message = appRepository.getById(searchMessageRequest.messageUUID?:throw Exception("wrong messageUuid"))
        context.setQuery(searchMessageRequest)
        context.setMessageRecord(message)
        return context.toSearchMessageResponse()
    }

    fun readHandler(readMessageRequest: ReadMessageRequest): ReadMessageResponse {
        val context = AppContext()
        val message = appRepository.getById(readMessageRequest.messageUUID)
        context.setMessageRecord(message)
        context.setQuery(readMessageRequest)
        return context.toReadMessageResponse()
    }

}