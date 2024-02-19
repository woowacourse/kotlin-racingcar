package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarsTest {
    private lateinit var validCars: Cars

    @BeforeEach
    fun setUp() {
        validCars = Cars.from("pang,shim,hae")
    }

    @Test
    fun `중복된 자동차 이름 검증`() {
        assertThatThrownBy {
            Cars.from("aa,bb,aa")
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복된 이름이 존재합니다.")
    }

    @Test
    fun `자동차 이름에 중복이 없을 시 성공`() {
        assertDoesNotThrow {
            validCars
        }
    }

    @Test
    fun `전진 전략이 참일 때 자동차가 전진한다`() {
        validCars.startPhaseWith(MoveStrategyIsAlways(true))
        assertTrue { validCars.cars.all { it.position == 1 } }
    }

    @Test
    fun `전진 전략이 거짓일 때 자동차는 멈춘다`() {
        validCars.startPhaseWith(MoveStrategyIsAlways(false))
        assertTrue { validCars.cars.all { it.position == 0 } }
    }
}
