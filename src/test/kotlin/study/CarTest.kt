package study

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    fun `유효한 자동차 이름으로 Car 객체 생성`() {
        val car = Car("valid", 0)
        // 성공적으로 생성되었는지 확인
        assertEquals("valid", car.name)
    }

    @Test
    fun `5글자를 초과하는 이름으로 Car 객체 생성 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("tooLongName", 0)
        }
    }

    @Test
    fun `빈 이름으로 Car 객체 생성 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("", 0)
        }
    }
}
