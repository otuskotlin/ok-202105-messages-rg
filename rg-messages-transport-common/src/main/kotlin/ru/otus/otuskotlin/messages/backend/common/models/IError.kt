package ru.otus.otuskotlin.messages.backend.common.models

interface IError {
    var field: String
    var level: Level
    var message: String

    enum class Level {
        ERROR,
        WARNING
    }
}
