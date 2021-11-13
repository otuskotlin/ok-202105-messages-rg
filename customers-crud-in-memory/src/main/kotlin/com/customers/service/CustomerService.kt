package com.customers.service

import com.customers.mappers.setCustomerRow
import com.customers.mappers.setCustomerRowList
import com.customers.mappers.toCustomerResponse
import com.customers.mappers.toCustomerRow
import com.customers.model.CustomerContext
import com.customers.repository.CustomersRepository
import com.messages.openapi.models.CustomerCommandResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(
    private val customerRepo: CustomersRepository
) {
    fun create(context: CustomerContext): UUID {
        return customerRepo.create(context.toCustomerRow())
    }

    fun read(context: CustomerContext): CustomerCommandResponse {
        val row = customerRepo.read(context)
        context.setCustomerRow(row)
        return context.toCustomerResponse()
    }

    fun update(context: CustomerContext) {
        customerRepo.update(context.toCustomerRow())
    }

    fun delete(uuid: UUID) {
        customerRepo.delete(uuid)
    }

    fun search(context: CustomerContext): CustomerContext {
        val search = customerRepo.search(context)
        context.setCustomerRowList(search)
        return context
    }
}