package com.support.mappers

import com.messages.support.openapi.models.*
import com.support.models.*
import java.time.OffsetDateTime
import java.util.*

fun CreateContext.setQuery(query: CreateSupportRequest) = apply {
    requestUUID = query.requestUUID ?: java.util.UUID.randomUUID()
    supportModel = query.toModel()
}

fun ReadContext.setQuery(query: ReadSupportRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
}

fun UpdateContext.setQuery(query: UpdateSupportRequest) = apply {
    requestUUID = query.requestUUID ?: java.util.UUID.randomUUID()
    supportModel = query.toModel()
}

fun DeleteContext.setQuery(query: DeleteSupportRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()
    supportUUID = query.supportUUID
}

fun SearchContext.setQuery(query: SearchSupportRequest) = apply {
    requestUUID = query.requestUUID ?: UUID.randomUUID()

}

private fun CreateSupportRequest.toModel() = SupportModel(
    uuid = UUID.randomUUID(),
    updated = OffsetDateTime.now(),
    created = OffsetDateTime.now(),
    email = this.email,
    name = this.name
)

private fun UpdateSupportRequest.toModel() = SupportModel(
    uuid = this.uuid,
    updated = OffsetDateTime.now(),
    email = this.email,
    name = this.name
)