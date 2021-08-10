package ru.otus.otuskotlin.messages.backend.common.models

import ru.otus.otuskotlin.marketplace.backend.common.models.AdIdModel

data class PaginatedModel(
    var size: Int = Int.MIN_VALUE,
    var lastId: AdIdModel = AdIdModel.NONE,
    var position: PositionModel = PositionModel.NONE,
) {
    enum class PositionModel {
        NONE,
        FIRST,
        MIDDLE,
        LAST;
    }
}
