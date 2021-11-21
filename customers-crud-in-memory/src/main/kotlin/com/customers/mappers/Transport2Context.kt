package com.customers.mappers

import com.customers.model.CustomerContext
import com.customers.model.CustomerModel
import com.messages.openapi.models.CustomerCommandRequest
import java.time.OffsetDateTime


fun CustomerContext.setCommand(req: CustomerCommandRequest) {
    this.customerModel = CustomerModel(
        uuid = req.id,
        name = req.name,
        email = req.email,
        password = req.password,
        created = OffsetDateTime.now(),
        updated = OffsetDateTime.now()
    )
}