import controller.Controller
import domain.RandomNumberGenerator
import exception.Validator
import view.InputView
import view.OutputView

fun main() {
    val controller = Controller(InputView(Validator()), OutputView(), RandomNumberGenerator())
    controller.start()
}
