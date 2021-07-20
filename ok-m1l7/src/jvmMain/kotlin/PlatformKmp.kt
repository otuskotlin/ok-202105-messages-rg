package ru.otus.otuskotlin.marketplace.kmp

actual class PlatformKmp {
    actual fun init() = "Init JVM"
    actual fun initHW(): String {
      return "JVM_HW"
    }
}
