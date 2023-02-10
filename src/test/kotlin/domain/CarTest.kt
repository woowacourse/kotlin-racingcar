package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val numberGenerator = TestNumberGenerator(listOf())

    @Test
    fun `자동차는 4 이상 값이 세 번 나오면 세 칸 전진한다`() {
        val generator = TestNumberGenerator(listOf(2, 4, 3, 9, 5, 0))
        val name = "pobi"
        val car = Car(generator, name)
        val distances = listOf(0, 1, 1, 2, 3, 3)
        distances.map { distance -> assertThat(car.race().getDistance()).isEqualTo(distance) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `자동차 이름에 오류가 없으면 에러가 발생하지 않는다`(input: String) {
        Assertions.assertDoesNotThrow { Car(numberGenerator, input, 0) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Pobi", " jun", "po bi", "   "])
    fun `자동차 이름에 공백이 있거나 영문 소문자가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { Car(numberGenerator, input, 0) }
        assertThat(exception.message).isEqualTo(Car.ERROR_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["woniii", ""])
    fun `자동차 이름이 1글자 이상 5글자 이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { Car(numberGenerator, input, 0) }
        assertThat(exception.message).isEqualTo(Car.ERROR_NAME_LENGTH)
    }

    class TestNumberGenerator(numbers: List<Int>) : NumberGenerator {
        private val numbers = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}
