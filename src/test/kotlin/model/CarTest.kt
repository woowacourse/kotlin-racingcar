package model

import model.generator.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["우아한테크코스", "배달의 민족", "만세만세만만세"])
    fun `5자 초과의 자동차 이름 확인하기`(name: String) {
        val exception: Throwable = assertThrows<IllegalArgumentException> { Car(name) }

        assertThat("$CAR_NAME_NUMBER_ERROR_MSG $name 은 5자를 초과합니다.").isEqualTo(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `공백의 자동차 이름 확인하기`(name: String) {
        val exception: Throwable = assertThrows<IllegalArgumentException> { Car(name) }

        assertThat("$CAR_NAME_BLANK_ERROR_MSG $name 은 공백입니다.").isEqualTo(exception.message)
    }

    private fun setNumber(n: NumberGenerator): Int {
        return n.generate()
    }

    @Test
    fun `정지 테스트 `() {
        val car = Car("우기")
        val condition = setNumber(object : NumberGenerator {
            override fun generate(): Int {
                return 0
            }
        })
        assertThat(car.move(condition)).isEqualTo(PathState.STOP)
    }

    @Test
    fun `전진 테스트 `() {
        val car = Car("핑구")
        val condition = setNumber(object : NumberGenerator {
            override fun generate(): Int {
                return 4
            }
        })
        assertThat(car.move(condition)).isEqualTo(PathState.MOVE)
    }

    companion object {
        const val CAR_NAME_NUMBER_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다."
        const val CAR_NAME_BLANK_ERROR_MSG = "[ERROR] 자동차 이름은 공백이 될 수 없습니다."
    }
}
