package com.support.models

import com.messages.support.openapi.models.RequestError
import java.util.*

class CreateContext(
    var supportModel: SupportModel?=null,
    errors: MutableList<RequestError> = mutableListOf(),
    requestUUID: UUID
) : BaseContext(errors, requestUUID) {


}