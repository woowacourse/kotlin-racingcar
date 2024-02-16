import controller.RacingGame
import domain.MoveStrategyUsingNumber
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

fun main() {
    RacingGame(
        InputView(),
        OutputView(),
        MoveStrategyUsingNumber(RandomNumberGenerator),
    ).start()
}
