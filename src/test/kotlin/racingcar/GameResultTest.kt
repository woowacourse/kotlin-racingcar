package racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameResultTest {

    @DisplayName("승자를 가져온다")
    @Test
    fun pickWinners() {
        val cars = createCars()
        cars.moveAll(listOf(3, 4, 4))

        val result = GameResult(cars)
        val winners = result.pickWinners()

        assertSoftly(winners) {
            shouldHaveSize(2)
            it[0] shouldBe "jae"
            it[1] shouldBe "choi"
        }
    }

    private fun createCars() = Cars.of(listOf("huni", "jae", "choi"))
}
