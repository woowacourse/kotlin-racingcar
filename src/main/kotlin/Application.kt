import controller.RacingController
import view.InputView
import view.OutputView

fun main() {
    RacingController(InputView(), OutputView()).run()
}