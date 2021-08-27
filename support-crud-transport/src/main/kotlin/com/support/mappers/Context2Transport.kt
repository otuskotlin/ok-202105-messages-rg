package com.support.mappers

import com.messages.support.openapi.models.*
import com.support.models.*


fun ReadContext.toReadSupportResponse() = ReadSupportResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    result = if (this.errors.isEmpty()) ReadSupportResponse.Result.SUCCESS else ReadSupportResponse.Result.ERROR
)

fun CreateContext.toCreateSupportResponse() = CreateSupportResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    result = if (this.errors.isEmpty()) CreateSupportResponse.Result.SUCCESS else CreateSupportResponse.Result.ERROR
)

fun UpdateContext.toUpdateSupportResponse() = UpdateSupportResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    result = if (this.errors.isEmpty()) UpdateSupportResponse.Result.SUCCESS else UpdateSupportResponse.Result.ERROR
)

fun DeleteContext.toDeleteMessageResponse() = DeleteSupportResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    result = if (this.errors.isEmpty()) DeleteSupportResponse.Result.SUCCESS else DeleteSupportResponse.Result.ERROR
)

fun SearchContext.toSearchMessageResponse() = SearchSupportResponse(
    requestUUID = this.requestUUID,
    errors = errors.takeIf { it.isNotEmpty() },
    result = if (this.errors.isEmpty()) SearchSupportResponse.Result.SUCCESS else SearchSupportResponse.Result.ERROR
)