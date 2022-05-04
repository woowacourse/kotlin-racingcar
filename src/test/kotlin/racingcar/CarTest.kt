package racingcar

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @DisplayName("생성 시 공백이 존재하면 에러가 발생한다.")
    @Test
    fun nameSpaceException() {
        assertThrows<IllegalArgumentException> {
            Car(" huni")
        }.shouldHaveMessage("[ERROR] 이름에 공백이 존재합니다.")
    }

    @DisplayName("이름을 입력하지 않은 경우 에러가 발생한다")
    @Test
    fun nameNotInsert() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }.shouldHaveMessage("[ERROR] 이름을 입력하지 않았습니다.")
    }

    @DisplayName("이름이 5자를 초과하면 에러가 발생한다.")
    @Test
    fun nameOverStandardLength() {
        assertThrows<IllegalArgumentException> {
            Car("hunuhk")
        }.shouldHaveMessage("[ERROR] 이름은 5자 이하로 입력하세요.")
    }

    @DisplayName("4이상의 수가 들어올 경우 전진한다.")
    @Test
    fun moveWhenOverStandard() {
        val car = Car("huni")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @DisplayName("3이하의 수가 들어올 경우 유지한다.")
    @Test
    fun noMoveWhenUnderStandard() {
        val car = Car("huni")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }
}
