package ru.otus.otuskotlin.messages.backend.transport.mapping.kmp

import org.example.openapi.models.UpdateMessageRequest
import ru.otus.otuskotlin.marketplace.backend.common.context.MpContext
import ru.otus.otuskotlin.marketplace.backend.common.models.*
import ru.otus.otuskotlin.messages.backend.common.models.*
import kotlin.test.Test
import kotlin.test.assertEquals

class MappingTest {

    @Test
    fun setUpdateQueryMappingTest() {
        val query = UpdateMessageRequest(
            requestId = "12345",
        )
        val context = MpContext().setQuery(query)
        assertEquals("12345", context.onRequest)
    }

    @Test
    fun updateResponseMappingTest() {
        val context = MpContext(
            onRequest = "12345",
            responseAd = AdModel(
                id = AdIdModel("id-1"),
                title = "title-1",
                description = "description-1",
                ownerId = OwnerIdModel("owner_id-1"),
                visibility = AdVisibilityModel.REGISTERED_ONLY,
                dealSide = DealSideModel.DEMAND,
            ),
            errors = mutableListOf(CommonErrorModel(level = IError.Level.WARNING)),
        )
        val response = context.toUpdateResponse()
        assertEquals("12345", response.requestId)
        assertEquals(1, response.errors?.size)
    }
}
