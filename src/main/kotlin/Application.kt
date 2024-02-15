import controller.RacingGame
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

fun main() {
    RacingGame(
        InputView(),
        OutputView(),
        RandomNumberGenerator()
    ).start()
}