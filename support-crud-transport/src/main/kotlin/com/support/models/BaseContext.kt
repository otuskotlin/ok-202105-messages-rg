package com.support.models

import com.messages.support.openapi.models.RequestError
import java.util.*

open class BaseContext(
    var errors: MutableList<RequestError>,
    var requestUUID: UUID
) {
}