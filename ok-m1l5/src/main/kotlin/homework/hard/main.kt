package homework.hard

import homework.hard.dto.Dictionary
import kotlinx.coroutines.*
import java.io.File
import kotlin.coroutines.CoroutineContext
import kotlin.streams.toList

fun main() {
    val start = System.currentTimeMillis()
    val dictionaryApi = DictionaryApi()
    val words = FileReader.readFile().split(" ", "\n").toSet()

    val dictionaries = runBlocking {
        return@runBlocking findWords(dictionaryApi, words, Locale.EN)
    }
    println("size-> ${dictionaries.size}")
    dictionaries.map { dictionary ->
        print("For word ${dictionary.word} i found examples: ")
        println(dictionary.meanings.map { definition -> definition.definitions.map { it.example } })
    }
    val finish = System.currentTimeMillis()
    println("result -> ${finish - start}")
}

 suspend fun findWords(dictionaryApi: DictionaryApi, words: Set<String>, locale: Locale): List<Dictionary> {
     var dictList = listOf<Dictionary>()
     coroutineScope {
         val map = words.parallelStream().map {
             var value:Dictionary = Dictionary("", emptyList())
             launch {
                 println("courutine was launched")
                 value = dictionaryApi.findWord(locale, it)
             }
             return@map value
         }
         dictList =  map.toList()
     }
    return dictList
}// make some suspensions and async



object FileReader {
    fun readFile(): String =
        File(this::class.java.classLoader.getResource("words.txt")?.toURI() ?: throw RuntimeException("Can't read file")).readText()
}
