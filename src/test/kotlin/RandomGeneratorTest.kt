import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.util.RandomGenerator

class RandomGeneratorTest {
    private val randomGenerator = RandomGenerator()

    @Test
    fun `랜덤으로 생성된 숫자는 0이상 9이하여야 한다`() {
        val randomNumber = randomGenerator.getRandomNumber()
        val range = 0..9

        Assertions.assertTrue(randomNumber in range)
    }
}
