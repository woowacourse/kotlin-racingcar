package racingcar

import io.kotest.matchers.throwable.haveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CarTest {

    @DisplayName("생성 시 공백이 존재하면 에러가 발생한다.")
    @Test
    fun nameSpaceException() {
        assertThrows<IllegalArgumentException> {
            Car(" huni")
            haveMessage("[ERROR] 이름에 공백이 존재합니다.")
        }
    }

    @DisplayName("이름을 입력하지 않은 경우 에러가 발생한다")
    @Test
    fun nameNotInsert() {
        assertThrows<IllegalArgumentException> {
            Car("")
            haveMessage("[ERROR] 이름을 입력하지 않았습니다.")
        }
    }

    @DisplayName("이름이 5자를 초과하면 에러가 발생한다.")
    @Test
    fun nameOverStandardLength() {
        assertThrows<IllegalArgumentException> {
            Car("hunuhk")
            haveMessage("[ERROR] 이름은 5자 이하로 입력하세요.")
        }
    }

    @DisplayName("position을 입력하지않으면 0 포지션의 차가 생성된다.")
    @Test
    fun createCarNoPositionInsert() {
        val car = Car("huni")
        assertThat(car).isEqualTo(Car("huni", 0))
    }
}
