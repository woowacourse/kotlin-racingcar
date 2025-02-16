package racingCar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val car = Car("뭉치")

    @ParameterizedTest
    @ValueSource(strings = [" ", "", "  "])
    fun `자동차 이름이 공백일 때 에러를 발생시킨다`(carName: String) {
        assertThrows<IllegalArgumentException> { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456", ""])
    fun `자동차 이름의 길이가 0자 이거나 5자 초과할 때 에러를 발생시킨다`(carName: String) {
        assertThrows<IllegalArgumentException> { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["뭉치", "코난", "철수"])
    fun `자동차 이름이 조건을 충족할 때 에러를 발생시키지 않는다`(name: String) {
        assertDoesNotThrow { Car(name) }
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        // given:
        // when:
        val actual = 0
        // then:
        Assertions.assertEquals(actual, car.position)
    }

    @Test
    fun `1번 전진한 후 자동차는 이전 위치보다 1 앞서있다`() {
        // given:
        val previousPosition = car.position
        // when:
        car.moveForward()
        // then:
        Assertions.assertTrue(car.position == previousPosition + 1)
    }

    @Test
    fun `전진을 못하면 자동차는 이전 위치와 같다`() {
        // given:
        val previousPosition = car.position
        // when:
        // then:
        Assertions.assertTrue(car.position == previousPosition)
    }
}
