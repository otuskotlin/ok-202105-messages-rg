package com.customers.mappers

import com.customers.model.CustomerContext
import com.customers.model.CustomerRow
import java.util.*

fun CustomerContext.toCustomerRow(): CustomerRow {
    val customerContext = this.customerModel
    return CustomerRow(customerContext?.uuid?: UUID.randomUUID()).apply {
        customerContext?.name?.let { name = it }
        customerContext?.email?.let { email = it }
        customerContext?.password?.let { password = it }
        customerContext?.created?.let { created = it }
        customerContext?.updated?.let { updated = it }
    }
}
