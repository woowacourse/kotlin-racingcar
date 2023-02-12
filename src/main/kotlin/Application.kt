import controller.Controller
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

fun main() {
    val generator = RandomNumberGenerator()
    val inputView = InputView()
    val outputView = OutputView()

    Controller(generator, inputView, outputView).run()
}
