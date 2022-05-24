package racingcar

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.Test
import io.kotest.matchers.collections.shouldContainExactly

class CarsTest : AnnotationSpec() {

    @Test
    fun `우승자를 판단한다`() {
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")
        car1.move(4)
        car2.move(4)

        val cars = Cars(listOf(car1, car2, car3))

        val winners = cars.findWinners()
        winners.shouldContainExactly(car1, car2)
    }
}
