package com.support.models

import com.messages.support.openapi.models.RequestError
import java.util.*

class ReadContext(
    var supportModel: SupportModel,
    errors: MutableList<RequestError>,
    requestUUID: UUID
) :BaseContext(errors, requestUUID) {
}