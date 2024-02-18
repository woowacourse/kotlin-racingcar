package racingcar.model

import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM

class RandomNumberGeneratorTest {
    private lateinit var numberGenerator: NumberGenerator

    @BeforeEach
    fun setup() {
        numberGenerator = RandomNumberGenerator()
    }

    @RepeatedTest(value = 100)
    fun `선택된 랜덤 숫자가 허용 범위 내에 있는지의 여부 테스트`() {
        val randomNumber = numberGenerator.getNumber()
        assertThat(randomNumber).isBetween(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM)
    }
}
