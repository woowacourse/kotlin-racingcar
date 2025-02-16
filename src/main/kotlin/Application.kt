import controller.RacingGameController
import view.InputView
import view.OutputView

fun main() {
    val racingGameController = RacingGameController(InputView(), OutputView())

    racingGameController.startRacingGameProgram()
}
