package com.messages.controller

import org.example.openapi.models.CreateMessageRequest
import org.example.openapi.models.ReadMessageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("messages")
class AppController {

    @PostMapping("/create")
    fun createMessage(createMessageRequest: CreateMessageRequest): ResponseEntity<String> {
        return ResponseEntity.ok("Message created")
    }
    @PostMapping("/read")
    fun readMessage(readMessageRequest: ReadMessageRequest): ResponseEntity<String>? {
        return ResponseEntity.ok("Message read")
    }

    @PostMapping("/update")
    fun updateMessage(): ResponseEntity<String>? {
        return ResponseEntity.ok("Message updated")
    }
    @PostMapping("/delete")
    fun deleteMessage(): ResponseEntity<String>? {
        return ResponseEntity.ok("Message deleted")
    }
    @PostMapping("/search")
    fun searchMessage(): ResponseEntity<String>? {
        return ResponseEntity.ok("Message was found")
    }

}