package ru.otus.otuskotlin.marketplace.kmp

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformKmpJsTest {
    @Test
    fun allTest() {
        assertTrue("Must contain Platform word") {
            PlatformKmp().init().contains("JS")
        }
        assertTrue("Must contain Platform word") {
            PlatformKmp().initHW().contains("JavaScript")
        }
        assertFalse("Must not contain this word") {
            PlatformKmp().initHW().contains("JavasdssScript")
        }
    }
}
