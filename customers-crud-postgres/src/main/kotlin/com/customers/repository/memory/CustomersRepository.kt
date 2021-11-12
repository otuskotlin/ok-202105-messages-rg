package com.customers.repository.memory

interface CustomersRepository {
    fun create( )
    fun read()
    fun update( )
    fun delete( )
    fun search( )
}