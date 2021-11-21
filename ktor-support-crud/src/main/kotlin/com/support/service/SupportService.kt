package com.support.service

import com.chain
import com.handlers.worker
import com.messages.support.openapi.models.*
import com.support.fromJson

import com.support.mappers.setQuery
import com.support.mappers.toCreateSupportResponse
import com.support.models.CreateContext
import java.util.*
import java.util.regex.Pattern


class SupportService {

    suspend fun createSupport(req: String): String {
        val createContext = CreateContext(
            requestUUID = UUID.randomUUID()
        )
        createContext.setQuery(req.fromJson<CreateSupportRequest>())
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        chain<CreateContext> {
            description = "Валидация важных полей"
            worker {
                description="Валидация email"

                on { !pattern.matcher(createContext.supportModel?.email).matches() }
                handle { throw Exception("wrong email") }
                except { e:Throwable -> println("Exception ${e.message}") }
            }
            worker {
                description="валидация имени"

                on { (createContext.supportModel?.name?.length!! > 30 || createContext.supportModel?.name?.length!! < 3) }
                handle { throw Exception("wrong name") }
                except { e:Throwable -> println("Exception ${e.message}") }
            }
        }.build().exec(createContext)
        return createContext.toCreateSupportResponse()
    }


    fun readSupport(request: ReadSupportRequest) {

    }

    fun updateSupport(request: UpdateSupportRequest) {

    }

    fun deleteSupport(req: DeleteSupportRequest) {

    }
}