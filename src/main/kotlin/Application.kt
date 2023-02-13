import controller.Controller
import domain.Judgment
import domain.RandomNumberGenerator
import exception.InputValidator
import view.InputView
import view.OutputView

fun main() {
    val controller = Controller(InputView(InputValidator()), OutputView(), RandomNumberGenerator(), Judgment())
    controller.start()
}
