package model

import model.generator.NumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["우아한테크코스", "배달의 민족", "만세만세만만세"])
    fun `5자 초과의 자동차 이름 확인하기`(name: String) {
        val exception: Throwable = assertThrows<IllegalArgumentException> { Car(name) }
        assertEquals(CAR_NAME_NUMBER_ERROR_MSG, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `공백의 자동차 이름 확인하기`(name: String) {
        val exception: Throwable = assertThrows<IllegalArgumentException> { Car(name) }
        assertEquals(CAR_NAME_BLANK_ERROR_MSG, exception.message)
    }

    private fun setNumberListener(n: NumberGenerator): Int {
        return n.generate()
    }

    @Test
    fun `정지 테스트 `() {
        val car = Car("우기")
        val condition = setNumberListener(object : NumberGenerator {
            override fun generate(): Int {
                return STOP_NUMBER
            }
        })
        Assertions.assertThat(car.move(condition)).isEqualTo(PathState.STOP)
    }

    @Test
    fun `전진 테스트 `() {
        val car = Car("핑구")
        val condition = setNumberListener(object : NumberGenerator {
            override fun generate(): Int {
                return MOVE_NUMBER
            }
        })
        Assertions.assertThat(car.move(condition)).isEqualTo(PathState.MOVE)
    }

    companion object {
        const val CAR_NAME_NUMBER_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다."
        const val CAR_NAME_BLANK_ERROR_MSG = "[ERROR] 자동차 이름은 공백이 될 수 없습니다."
        const val MOVE_NUMBER = 4
        const val STOP_NUMBER = 0
    }
}
