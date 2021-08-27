package com.support.models

import com.messages.support.openapi.models.RequestError
import java.util.*

class DeleteContext(
    var supportUUID: UUID,
    errors: MutableList<RequestError>,
                    requestUUID: UUID):BaseContext(errors, requestUUID) {
}