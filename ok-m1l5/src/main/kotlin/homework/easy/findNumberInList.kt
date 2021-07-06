package homework.easy

suspend fun findNumberInList(toFind: Int, numbers: List<Int>): Int {
    Thread.sleep(2000L)
    return numbers.firstOrNull { it == toFind } ?: -1
}

