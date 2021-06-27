import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class FirstTest {
    @Test
    fun test(){
       assertEquals(1+1,2)
    }
    @Test
    fun test2(){
        val first = BigInteger("5")
        val second = BigInteger("6")
        val expectedPair = Pair(first, second)

        assertEquals(expectedPair,foo(5L,6L))
        assertEquals(expectedPair,foo(5,6))
        assertEquals(expectedPair,foo(first,second))


    }
    fun <T, V> foo(a: T, b: V): Pair<BigInteger, BigInteger> {
        return Pair(convertToBigInteger(a), convertToBigInteger(b))
    }
    fun<T> convertToBigInteger(value: T):BigInteger{
        return when(value){
            is Long ->  value.toBigInteger()
            is Int -> value.toBigInteger()
            is BigInteger -> value
            else -> throw RuntimeException("unexpected  class")
        }
    }
}
