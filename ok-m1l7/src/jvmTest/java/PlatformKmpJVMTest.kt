import ru.otus.otuskotlin.marketplace.kmp.PlatformKmp
import kotlin.test.Test
import kotlin.test.assertTrue

class PlatformKmpJVMTest {
    @Test
    fun allTest() {
        assertTrue("Must contain Platform word") {
            PlatformKmp().init().contains("JVM")
        }
        assertTrue("Must contain Platform word") {
            PlatformKmp().initHW().contains("JVM")
        }
    }
}
