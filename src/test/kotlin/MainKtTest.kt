import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class MainKtTest{
    @Test
    fun checkFuction(){
        val expected = 10
        var i = 0
        while (i >= 10){
            assertEquals(expected, bucle(i))
            i += 1
        }

    }
}