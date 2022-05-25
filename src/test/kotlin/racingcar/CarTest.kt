package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car

class CarTest : AnnotationSpec() {

    @Test
    fun `처음 생성한 자동차의 위치는 0`() {
        val car = Car("jason")
        car.position shouldBe 0
    }

    @Test
    fun `자동차 이름이 5자를 초과할 경우 예외를 던진다`() {
        val invalidName = "123456"

        shouldThrow<IllegalArgumentException> {
            Car(invalidName)
        }
    }

    @Test
    fun `자동차 이름이 빈 값일 경우 예외를 던진다`() {
        val invalidName = ""

        shouldThrow<IllegalArgumentException> {
            Car(invalidName)
        }
    }

    @Test
    fun `4이상인 경우 자동차의 position이 1 증가`() {
        val car = Car("json")
        car.move(4)
        car.position shouldBe 1
    }

    @Test
    fun `3이하인 경우 자동차의 position 유지`() {
        val car = Car("brown")
        car.move(3)
        car.position shouldBe 0
    }
}
