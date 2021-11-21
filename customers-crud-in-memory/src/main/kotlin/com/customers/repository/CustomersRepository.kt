package com.customers.repository

import com.customers.model.CustomerContext
import com.customers.model.CustomerRow
import org.ehcache.Cache
import java.util.*

interface CustomersRepository {
    fun create(value: CustomerRow): UUID
    fun read(customerContext: CustomerContext): CustomerRow
    fun update(value: CustomerRow)
    fun delete(uuid: UUID)
    fun size():Int
    fun search(customerContext: CustomerContext): List<Cache.Entry<UUID, CustomerRow>>
}