package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.entity.Name

class CarManagerTest {
    @Test
    fun `랜덤한 값 테스트`() {
        val numberGenerator = RandomNumberTest(listOf(1, 3, 5))
        val carManager = CarManager(listOf(Name("test1"), Name("test2"), Name("test3")), numberGenerator)

        carManager.attempt()

        val winners = carManager.determineWinner()
        Assertions.assertThat(winners[0].name.toString()).isEqualTo("test3")
    }

    @Test
    fun `우승자 결정 테스트`() {
        val carManager = CarManager(listOf(Name("test1"), Name("test2"), Name("test3")), RandomNumber)

        carManager.step(0, 3)
        carManager.step(1, 1)
        carManager.step(2, 7)
        carManager.step(0, 1)
        carManager.step(1, 5)
        carManager.step(2, 6)

        val winners = carManager.determineWinner()
        Assertions.assertThat(winners[0].name.toString()).isEqualTo("test3")
    }

    @Test
    fun `자동차 전진 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val carManager = CarManager(listOf(Name("test1"), Name("test2"), Name("test3")))
            carManager.step(0, 10)
        }
    }
}
