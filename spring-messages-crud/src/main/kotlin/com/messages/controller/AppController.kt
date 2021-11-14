package com.messages.controller

import com.messages.openapi.models.*
import com.messages.service.AppService
import org.springframework.http.MediaType

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class AppController(
    private val appService: AppService
) {

    @PostMapping(
        path = ["/create"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createMessage(@RequestBody createMessageRequest: CreateMessageRequest): ResponseEntity<CreateMessageResponse> {

        return ResponseEntity.ok(appService.createHandler(createMessageRequest))
    }

    @PostMapping(
        path = ["/read"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun readMessage(@RequestBody readMessageRequest: ReadMessageRequest): ResponseEntity<ReadMessageResponse> {

        return ResponseEntity.ok(appService.readHandler(readMessageRequest))
    }

    @PutMapping(
        path = ["/update"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateMessage(@RequestBody updateMessageRequest: UpdateMessageRequest): ResponseEntity<UpdateMessageResponse> {

        return ResponseEntity.ok(appService.updateHandler(updateMessageRequest))
    }

    @DeleteMapping(path = ["/delete"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
        )
    fun deleteMessage(@RequestBody deleteMessageRequest: DeleteMessageRequest): ResponseEntity<DeleteMessageResponse> {

        return ResponseEntity.ok(appService.deleteHandler(deleteMessageRequest))
    }

    @PostMapping(path = ["/search"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun searchMessage(@RequestBody searchMessageRequest: SearchMessageRequest): ResponseEntity<SearchMessageResponse> {

        return ResponseEntity.ok(appService.searchHandler(searchMessageRequest))
    }

}