package com.support

import com.chain
import com.handlers.worker
import com.messages.support.openapi.models.RequestError
import com.support.models.CreateContext
import com.support.models.SupportModel
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test


import java.time.OffsetDateTime
import java.util.*
import java.util.regex.Pattern
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun testCor() {
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val createContext = CreateContext(
            supportModel = SupportModel(
                email = "asd",
                name = "2",
                uuid = UUID.randomUUID(),
                updated = OffsetDateTime.now()
            ),
            requestUUID = UUID.randomUUID()

        )
        val chainCor = chain<CreateContext> {
            description = "Валидация важных полей"
            worker {
                description = "Валидация email"

                on { !pattern.matcher(createContext.supportModel?.email).matches() }
                handle { createContext.errors.add(RequestError("wrong email")) }
                except { e: Throwable -> println("Exception ${e.message}") }
            }
            worker {
                description = "валидация имени"

                on { (createContext.supportModel?.name?.length!! > 30 || createContext.supportModel?.name?.length!! < 3) }
                handle { createContext.errors.add(RequestError("wrong Name"))}
                except { e: Throwable -> println("Exception ${e.message}") }
            }
        }.build()
        runBlocking {
            chainCor.exec(createContext)
        }
        assertEquals(2, createContext.errors.size)
    }
}