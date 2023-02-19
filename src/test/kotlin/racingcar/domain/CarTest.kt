package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    lateinit var car: Car

    @BeforeEach
    fun beforeEach() {
        car = Car("otter")
    }

    @Test
    fun `자동차 이름의 길이가 1 미만일 때 에러가 발생합니다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `자동차 이름의 길이가 5 초과일 때 에러가 발생합니다`() {
        assertThrows<IllegalArgumentException> {
            Car("soodal")
        }
    }

    @Test
    fun `자동차는 한 칸 전진합니다`() {
        val car = Car("otter", 3)
        car.takeOneStepForward()

        assertEquals(car.getPosition(), 4)
    }

    @Test
    fun `자동차가 전진한 횟수 만큼 "-"가 표현됩니다`() {
        val car = Car("otter", 3)

        assertEquals(
            car.getPositionAsDash(),
            "---"
        )
    }
}
