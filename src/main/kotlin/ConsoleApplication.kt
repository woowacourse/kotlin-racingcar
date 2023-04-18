import controller.ConsoleController
import view.InputView
import view.OutputView

fun main() {
    val controller = ConsoleController(InputView(), OutputView())
    controller.run()
}
