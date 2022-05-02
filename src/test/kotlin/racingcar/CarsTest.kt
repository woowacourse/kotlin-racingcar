package racingcar

import io.kotest.matchers.throwable.haveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @DisplayName("중복된 이름이 존재하는 경우 예외를 발생한다.")
    @Test
    fun nameDuplicateException() {
        assertThrows<IllegalArgumentException> {
            Cars.of(listOf("huni", "huni"))
            haveMessage("[ERROR] 중복된 이름이 존재합니다.")
        }
    }

    @DisplayName("자동차의 개수가 0일 경우 예외를 발생한다.")
    @Test
    fun carsEmptyException() {
        assertThrows<IllegalArgumentException> {
            Cars.of(listOf())
            haveMessage("[ERROR] 최소 하나의 자동차를 입력하세요.")
        }
    }

    @DisplayName("정상적으로 cars를 생성한다.")
    @Test
    fun create() {
        var cars = Cars.of(listOf("huni", "choi", "jae"))
        assertAll(
            { assertThat(cars.cars).contains(Car("huni")) },
            { assertThat(cars.cars).contains(Car("choi")) },
            { assertThat(cars.cars).contains(Car("jae")) }
        )
    }

    @DisplayName("모든 자동차를 이동한다.")
    @Test
    fun moveAll() {
        var cars = Cars.of(listOf("huni", "choi", "jae"))
        cars.moveAll(listOf(3, 4, 4))
        assertAll(
            { assertThat(cars.cars[0].position).isEqualTo(0) },
            { assertThat(cars.cars[1].position).isEqualTo(1) },
            { assertThat(cars.cars[2].position).isEqualTo(1) }
        )
    }

    @DisplayName("이동 요소의 개수가 맞지 않을경우 에러를 발생한다.")
    @Test
    fun moveException() {
        var cars = Cars.of(listOf("huni", "choi", "jae"))
        assertThrows<IllegalArgumentException> {
            cars.moveAll(listOf(3, 4))
            haveMessage("[ERROR] 이동 요소 입력을 다시해주세요.")
        }
    }
}
