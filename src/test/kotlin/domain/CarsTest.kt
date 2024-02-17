package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarsTest {
    @Test
    fun `중복된 자동차 이름 검증`() {
        assertThatThrownBy {
            Cars.from("aa,bb,aa", RandomNumberGenerator)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복된 이름이 존재합니다.")
    }

    @Test
    fun `자동차 이름에 중복이 없을 시 성공`() {
        assertDoesNotThrow {
            Cars.from("aa,bb,cc", RandomNumberGenerator)
        }
    }

    @Test
    fun `한 번의 전진 결과를 확인`() {
        val cars = Cars.from("aa,bb,cc", ExplicitNumberGenerator(4))
        cars.startPhase()
        assertTrue { cars.cars.all { it.position == 1 } }
    }

    @Test
    fun `한 번의 멈춤 결과를 확인`() {
        val cars = Cars.from("aa,bb,cc", ExplicitNumberGenerator(3))
        cars.startPhase()
        assertTrue { cars.cars.all { it.position == 0 } }
    }
}
