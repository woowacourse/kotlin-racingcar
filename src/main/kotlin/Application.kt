import controller.RacingGameController
import service.RacingCarGameService
import view.InputView
import view.OutputView

fun main() {
    RacingGameController(InputView(), OutputView(), RacingCarGameService()).run()
}
