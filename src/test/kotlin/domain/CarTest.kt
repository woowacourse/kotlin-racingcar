package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    "3 이하의 숫자가 생성되면 정지한다." {
        val car = Car("자동차")

        car.move { 3 }

        car.position.value shouldBe 0
    }

    "4 이상의 숫자가 생성되면 전진한다." {
        val car = Car("자동차")

        car.move { 4 }

        car.position.value shouldBe 1
    }

    "자동차의 위치가 같은지 판단할 수 있다." {
        val car1 = Car("자동차1")
        val car2 = Car("자동차2")
        car1.move { 4 }
        car2.move { 4 }

        car1.isSamePosition(car2) shouldBe true
    }
})
