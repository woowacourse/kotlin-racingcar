package controller

import domain.Car
import domain.RandomNumberGenerator
import domain.TestNumberGenerator
import exception.InputValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import view.InputView
import view.OutputView

class ControllerTest {

    private val controller = Controller(InputView(InputValidator()), OutputView(), RandomNumberGenerator())

    @Test
    fun `우승자를 찾는다`() {
        val car1 = Car("a")
        val car2 = Car("b")
        val car3 = Car("c")

        car1.tryMove(TestNumberGenerator(3).generate())
        car2.tryMove(TestNumberGenerator(7).generate())
        car3.tryMove(TestNumberGenerator(1).generate())

        assertThat(controller.findWinners(listOf(car1, car2, car3))).isEqualTo(listOf("b"))
    }
}
