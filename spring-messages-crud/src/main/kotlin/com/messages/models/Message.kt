package com.messages.models

import java.time.OffsetDateTime
import java.util.*
import javax.persistence.*

@Table(name = "messages")
@Entity
data class Message(
    @Id
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    @GeneratedValue
    var id: UUID? = null,
    @Column(name = "parent_uuid", columnDefinition = "BINARY(16)")
    var parentUuid: UUID? = null,
    var payload: String? = null,
    @Column(name = "from", columnDefinition = "BINARY(16)")
    var from: UUID? = null,
    @Column(name = "to", columnDefinition = "BINARY(16)")
    var to: UUID? = null,
    var created: OffsetDateTime? = null,
    var updated: OffsetDateTime? = null
) {

}