import controller.Controller
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    Controller(inputView, outputView).run()
}
