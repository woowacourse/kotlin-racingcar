package racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    @DisplayName("중복된 이름이 존재하는 경우 예외를 발생한다.")
    @Test
    fun nameDuplicateException() {
        shouldThrow<IllegalArgumentException> {
            Cars.of(listOf("huni", "huni"))
        }.shouldHaveMessage("[ERROR] 중복된 이름이 존재합니다.")
    }

    @DisplayName("자동차의 개수가 0일 경우 예외를 발생한다.")
    @Test
    fun carsEmptyException() {
        shouldThrow<IllegalArgumentException> {
            Cars.of(listOf())
        }.shouldHaveMessage("[ERROR] 최소 하나의 자동차를 입력하세요.")
    }

    @DisplayName("정상적으로 cars를 생성한다.")
    @Test
    fun create() {
        val cars = Cars.of(listOf("huni", "choi", "jae"))

        assertSoftly(cars.cars) {
            shouldContain(Car("huni"))
            shouldContain(Car("choi"))
            shouldContain(Car("jae"))
        }
    }

    @DisplayName("모든 자동차를 이동한다.")
    @Test
    fun moveAll() {
        val cars = Cars.of(listOf("huni", "choi", "jae"))
        cars.moveAll(listOf(3, 4, 4))

        assertSoftly(cars.cars) {
            it[0].position shouldBe 0
            it[1].position shouldBe 1
            it[2].position shouldBe 1
        }
    }

    @DisplayName("이동 요소의 개수가 맞지 않을경우 에러를 발생한다.")
    @Test
    fun moveException() {
        val cars = Cars.of(listOf("huni", "choi", "jae"))
        shouldThrow<IllegalArgumentException> {
            cars.moveAll(listOf(3, 4))
        }.shouldHaveMessage("[ERROR] 이동 요소 입력을 다시해주세요.")
    }

    @DisplayName("최고 포지션을 계산한다.")
    @Test
    fun max() {
        val cars = Cars.of(listOf("huni", "choi", "jae"))
        cars.moveAll(listOf(3, 3, 4))

        cars.max() shouldBe 1
    }
}
