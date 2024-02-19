package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM
import java.lang.AssertionError

class NumberGeneratorTest {
    private lateinit var numberGenerator: NumberGenerator

    @BeforeEach
    fun setup() {
        val exceptionNumberPickingStrategy = object : PickingStrategy {
            override fun pickNumber(): Int = 10
        }
        numberGenerator = NumberGenerator(exceptionNumberPickingStrategy)
    }

    @Test
    fun `선택된 랜덤 숫자가 허용 범위 외에 있는 경우, 예외를 발생시킴`() {
        val randomNumber = numberGenerator.getNumber()
        assertThrows<AssertionError> {
            assertThat(randomNumber).isBetween(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM)
        }
    }
}
