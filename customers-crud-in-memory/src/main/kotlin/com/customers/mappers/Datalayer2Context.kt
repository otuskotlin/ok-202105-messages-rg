package com.customers.mappers

import com.customers.model.CustomerContext
import com.customers.model.CustomerModel
import com.customers.model.CustomerRow
import org.ehcache.Cache
import java.util.*

fun CustomerContext.setCustomerRow(value: CustomerRow) {
    customerModel = value.toCustomerModel()
}

fun CustomerRow.toCustomerModel() = CustomerModel(
    this.uuid,
    name = this.name,
    email = this.email,
    password = this.password,
    created = this.created,
    updated = this.updated
)

fun CustomerContext.setCustomerRowList(value: List<Cache.Entry<UUID, CustomerRow>>) {
    customerList = value.map { it.value.toCustomerModel() }
}