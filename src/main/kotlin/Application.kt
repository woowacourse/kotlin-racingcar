import controller.RacingGame
import domain.RandomNumberGenerator
import view.OutputView

fun main() {
    RacingGame(
        OutputView(),
        RandomNumberGenerator,
    ).start()
}
