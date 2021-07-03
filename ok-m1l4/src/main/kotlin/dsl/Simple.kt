package dsl

fun sout(block: () -> Any?) {
    val result = block()
    println(result)
}

class Context {
    fun time() = System.currentTimeMillis()
}

fun soutWithPrefix(blockWithContext: Context.() -> Any) {
    val context = Context()
    val value = blockWithContext(context)
    println("Ans: $value")
}
