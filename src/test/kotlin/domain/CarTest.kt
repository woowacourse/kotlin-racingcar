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

    "자동차가 특정 위치에 있는지 판단할 수 있다." {
        val car = Car("자동차1")
        car.move { 4 }

        car.isLocatedAt(Position(1)) shouldBe true
    }
})
