package racingCar.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import racingCar.model.RandomNumberGenerator

class RandomNumberGeneratorTest {
    @RepeatedTest(1000)
    @DisplayName("생성된 난수는 0 이상 9 이하의 자연수여야 한다.")
    fun randomNumberRangeTest() {
        val generator = RandomNumberGenerator()
        val randomNumber = generator.generate()
        assertTrue(randomNumber in 0..RandomNumberGenerator.MAX_VALUE)
    }
}
