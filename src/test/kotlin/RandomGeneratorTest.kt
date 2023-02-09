import generator.RandomGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGeneratorTest {

    @Test
    fun getRandomNumberTest() {
        var isTrue = true
        for (i in 1..100) {
            val number = RandomGenerator().getRandomNumber()
            if (number < 0 || number > 9) {
                isTrue = false
            }
        }
        assertThat(isTrue).isTrue
    }
}
