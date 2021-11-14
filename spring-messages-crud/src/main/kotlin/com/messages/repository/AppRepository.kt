package com.messages.repository

import com.messages.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppRepository: JpaRepository<Message, UUID> {

}