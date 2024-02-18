package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM

class RandomNumberGeneratorTest {
    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun setup() {
        randomNumberGenerator = RandomNumberGenerator()
    }

    @RepeatedTest(value = 100)
    fun `선택된 랜덤 숫자가 0에서 9 사이에 있는지의 여부 테스트`() {
        val randomNumber = randomNumberGenerator.getRandomNumber()
        assertThat(randomNumber).isBetween(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM)
    }
}
