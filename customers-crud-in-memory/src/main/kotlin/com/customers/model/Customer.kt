package com.customers.model

import java.time.OffsetDateTime
import java.util.*

data class CustomerRow(
    val uuid: UUID,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var created: OffsetDateTime? = null,
    var updated: OffsetDateTime? = null
)

data class CustomerModel(
    var uuid: UUID?,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var created: OffsetDateTime? = null,
    var updated: OffsetDateTime? = null
)

data class CustomerContext(
    var customerModel: CustomerModel? = null,
    var customerList: List<CustomerModel>? = null
) {

}

