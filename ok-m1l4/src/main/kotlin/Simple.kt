fun sout(block: () -> Any?,block2: () -> Any?) {
    val result = block()
    val result2 = block2()
    println(result)
    println(result2)
}

class MyContext {
    fun time() = System.currentTimeMillis()
}

fun soutWithPrefix(block: MyContext.() -> Any?) {
    val context = MyContext()
    val result = block(context)
    println(result)
}

