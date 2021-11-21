package com

import com.handlers.CorChainDsl
import com.handlers.CorWorkerDsl

interface ICorExecDsl<T> {
    var title: String
    var description: String
    fun build(): ICorExec<T>
}

interface ICorChainDsl<T> : ICorExecDsl<T>, ICorHandlerDsl<T> {
    fun add(worker: ICorExecDsl<T>)
}

interface ICorWorkerDsl<T> : ICorExecDsl<T>, ICorHandlerDsl<T> {
    fun handle(function: suspend T.() -> Unit)
}

interface ICorExec<T> {
    suspend fun exec(context: T)
}

interface ICorWorker<T> : ICorExec<T> {
    val title: String
    val description: String
    suspend fun on(context: T): Boolean
    suspend fun except(context: T, e: Throwable)
    suspend fun handle(context: T)

    override suspend fun exec(context: T) {
        if (on(context)) {
            try {
                handle(context)
            } catch (e: Throwable) {
                except(context, e)
            }
        }
    }
}

interface ICorHandlerDsl<T> {
    fun on(function: suspend T.() -> Boolean)
    fun except(function: suspend T.(e: Throwable) -> Unit)
}

fun <T> chain(function: CorChainDsl<T>.() -> Unit) = CorChainDsl<T>().apply(function)
fun <T> worker(function: CorWorkerDsl<T>.() -> Unit) = CorWorkerDsl<T>().apply(function)

