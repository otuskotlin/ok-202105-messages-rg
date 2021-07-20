import kotlin.test.Test
import kotlin.test.assertEquals

class TestCase {
    @Test
    fun testing(){
        val testProperty = Main().testProperty
        assertEquals("testing", testProperty)
    }
}