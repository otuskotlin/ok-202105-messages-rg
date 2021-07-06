package homework.easy

import kotlinx.coroutines.runBlocking

fun main() {
    val start = System.currentTimeMillis()
    val numbers = generateNumbers()
    val toFind = 10
    val toFindOther = 1000

    val foundNumbers = runBlocking {
        return@runBlocking listOf(
            findNumberInList(toFind, numbers),
            findNumberInList(toFindOther, numbers)
        )
    }
     foundNumbers.forEach {
         if (it != -1) {
             println("Your number found!")
         } else {
             println("Not found number $toFind")
         }
     }
    val finish = System.currentTimeMillis()
    println("result => ${finish-start}")
}