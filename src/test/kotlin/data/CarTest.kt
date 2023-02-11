package data

import data.generator.NumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["우아한테크코스", "배달의 민족", "만세만세만만세", " "])
    fun `유효하지 않은 자동차 이름 확인하기`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @Test
    fun `정지 테스트 `() {
        val car = Car("우기")
        val condition = object : NumberGenerator {
            override fun generate(): Int {
                return (0..3).random()
            }
        }.generate()
        Assertions.assertThat(car.move(condition)).isEqualTo(PathState.STOP)
    }

    @Test
    fun `전진 테스트 `() {
        val car = Car("핑구")
        val condition = object : NumberGenerator {
            override fun generate(): Int {
                return (4..9).random()
            }
        }.generate()
        Assertions.assertThat(car.move(condition)).isEqualTo(PathState.MOVE)
    }

    companion object {
        const val MOVE_NUMBER = 4
        const val STOP_NUMBER = 0
    }
}
