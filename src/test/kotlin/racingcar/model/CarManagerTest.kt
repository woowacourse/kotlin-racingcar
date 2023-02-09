package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.entity.Name

class CarManagerTest {
    @Test
    fun `우승자 결정 테스트`() {
        val carManager = CarManager()
        carManager.init(mutableListOf(Name("test1"), Name("test2"), Name("test3")))

        carManager.step(0, 3)
        carManager.step(1, 1)
        carManager.step(2, 7)
        carManager.step(0, 1)
        carManager.step(1, 5)
        carManager.step(2, 6)

        val winners = carManager.determineWinner()
        Assertions.assertThat(winners[0].getName()).isEqualTo(Name("test3"))
    }

    @Test
    fun `자동차 초기화 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val carManager = CarManager()
            carManager.init(listOf(Name("test1")))
        }
    }

    @Test
    fun `자동차 전진 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val carManager = CarManager()
            carManager.init(mutableListOf(Name("test1"), Name("test2"), Name("test3")))
            carManager.step(0, 10)
        }
    }
}
