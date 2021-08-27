package com.support.models

import java.time.OffsetDateTime
import java.util.*

class SupportModel(
    val uuid: UUID,
    val name:String,
    val email:String,
    val created:OffsetDateTime = OffsetDateTime.now(),
    val updated:OffsetDateTime
) {

}