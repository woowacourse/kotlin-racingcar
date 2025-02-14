package racingCar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarErrorTest {
    @Test
    fun `자동차 이름이 공백일 때 에러를 발생시킨다`() {
        // given:
        val carNames = listOf(" ", "", "  ")
        // when:
        // then:
        assertThrows<IllegalArgumentException> { CarError.validate(carNames) }
    }

    @Test
    fun `자동차 이름의 길이가 0자 이거나 5자 초과할 때 에러를 발생시킨다`() {
        // given:
        val carNames = listOf("123456", "")
        // when:
        // then:
        assertThrows<IllegalArgumentException> { CarError.validate(carNames) }
    }

    @Test
    fun `자동차 이름들이 중복이 있을 경우 에러를 발생시킨다`() {
        // given:
        val carNames = listOf("뭉치", "뭉치", "뭉칠")
        // when:
        // then:
        assertThrows<IllegalArgumentException> { CarError.validate(carNames) }
    }

    @Test
    fun `자동차 이름이 조건을 충족할 때 에러를 발생시키지 않는다`() {
        // given:
        val carNames = listOf("뭉치", "코난")
        // when:
        // then:
        assertDoesNotThrow { CarError.validate(carNames) }
    }
}
