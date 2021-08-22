package com.messages.controller

import com.messages.openapi.models.*
import com.messages.service.AppService

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/messages")
class AppController(
    private val appService: AppService
) {

    @PostMapping("/create")
    fun createMessage(@RequestBody createMessageRequest: CreateMessageRequest): CreateMessageResponse {

        return appService.createHandler(createMessageRequest)
    }

    @PostMapping("/read")
    fun readMessage(@RequestBody readMessageRequest: ReadMessageRequest): ReadMessageResponse {

        return appService.readHandler(readMessageRequest)
    }

    @PostMapping("/update")
    fun updateMessage(@RequestBody updateMessageRequest: ReadMessageRequest): ResponseEntity<String>? {
        appService.updateHandler(updateMessageRequest)
        return ResponseEntity.ok("Message updated")
    }

    @PostMapping("/delete")
    fun deleteMessage(@RequestBody deleteMessageRequest: DeleteMessageRequest): ResponseEntity<String>? {
        appService.deleteHandler(deleteMessageRequest)
        return ResponseEntity.ok("Message deleted")
    }

    @PostMapping("/search")
    fun searchMessage(@RequestBody searchMessageRequest: SearchMessageRequest): ResponseEntity<String>? {
        appService.searchHandler(searchMessageRequest)
        return ResponseEntity.ok("Message was found")
    }

}