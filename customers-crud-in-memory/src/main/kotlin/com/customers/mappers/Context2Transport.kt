package com.customers.mappers

import com.customers.model.CustomerContext
import com.messages.openapi.models.CustomerCommandResponse

fun CustomerContext.toCustomerResponse(): CustomerCommandResponse {
    return CustomerCommandResponse(
        id = this.customerModel?.uuid ?: throw Exception("something went wrong"),
        name = this.customerModel?.name ?: throw Exception("something went wrong"),
        email = this.customerModel?.email ?: throw Exception("something went wrong"),
        password = this.customerModel?.password ?: throw Exception("something went wrong"),
        created = (this.customerModel?.created ?: throw Exception("something went wrong")).toString(),
        updated = (this.customerModel?.updated ?: throw Exception("something went wrong")).toString(),
    )
}