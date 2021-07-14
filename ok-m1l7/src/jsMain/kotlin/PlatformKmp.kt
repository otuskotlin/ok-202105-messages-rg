package ru.otus.otuskotlin.marketplace.kmp

actual class PlatformKmp {
    actual fun init() = "Init JS"
    actual fun initHW(): String {
       return "JavaScript_HW"
    }
}
