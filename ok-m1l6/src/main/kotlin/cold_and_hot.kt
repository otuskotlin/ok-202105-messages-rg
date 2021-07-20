import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

suspend fun main(): Unit = coroutineScope {
    // Если запускать только холодный поток, то приложение завершит работу
    val coldFlow = flow<Int> { println("I'm cold") }
    launch { coldFlow.collect() }
    launch { coldFlow.collect() }

    // если запускать горячий поток, то приложение будет продолжать работать
    // Если в контексте горячего потока будет поялвять ся новое значение
    // то оно будет собрано методом collect
    val hotFlow = flow<Int> {
        println("I'm hot")
    }.shareIn(this, SharingStarted.Lazily)
    launch { hotFlow.collect() }
    launch { hotFlow.collect() }
}