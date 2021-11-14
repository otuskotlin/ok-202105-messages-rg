package com.support.service

import com.messages.support.openapi.models.*
import com.support.mappers.setQuery
import com.support.mappers.toCreateSupportResponse
import com.support.models.CreateContext
import org.springframework.stereotype.Service
import java.util.*


@Service
class SupportService {

    fun createSupport(req: CreateSupportRequest): CreateSupportResponse {
        return CreateContext(
            requestUUID = UUID.randomUUID()
        ).setQuery(req).toCreateSupportResponse()
    }

    fun readSupport(request: ReadSupportRequest) {

    }

    fun updateSupport(request: UpdateSupportRequest) {

    }

    fun deleteSupport(req: DeleteSupportRequest) {

    }
}