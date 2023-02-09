import view.InputView
import view.OutputView

fun main() {
    val gameController = GameController(InputView(), OutputView())

    with(gameController) {
        standByPhase()
        playingPhase()
        endPhase()
    }
}
