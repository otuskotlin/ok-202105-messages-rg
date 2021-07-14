package ru.otus.otuskotlin.marketplace.kmp

actual class PlatformKmp {
    actual fun init(): String = "Init LinuxX64"
    actual fun initHW(): String {
        return "Linux_HW"
    }
}
