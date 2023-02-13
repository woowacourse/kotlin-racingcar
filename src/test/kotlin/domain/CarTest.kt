package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["Pobi", "woni ", " jun", "po bi", " "])
    fun `자동차 이름에 공백이 있거나 영문 소문자가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(
                object : NumberGenerator {
                    private val numbers = mutableListOf(2, 4, 3, 9, 5, 0)

                    override fun generate(): Int {
                        return numbers.removeAt(0)
                    }
                },
                input,
            )
        }
        assertThat(exception.message).contains(Car.ERROR_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["woniii", ""])
    fun `자동차 이름이 1글자 이상 5글자 이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(
                object : NumberGenerator {
                    private val numbers = mutableListOf(2, 4, 3, 9, 5, 0)

                    override fun generate(): Int {
                        return numbers.removeAt(0)
                    }
                },
                input,
            )
        }
        assertThat(exception.message).contains(Car.ERROR_NAME_LENGTH)
    }

    @Test
    fun `자동차 이동 테스트`() {
        val name = "pobi"
        val car = Car(
            object : NumberGenerator {
                private val numbers = mutableListOf(2, 4, 3, 9, 5, 0)

                override fun generate(): Int {
                    return numbers.removeAt(0)
                }
            },
            name,
        )
        val distances = listOf(0, 1, 1, 2, 3, 3)
        distances.forEach { distance ->
            assertThat(car.race().distance).isEqualTo(distance)
        }
    }
}
