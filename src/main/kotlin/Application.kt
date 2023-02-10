import controller.RaceGame
import view.InputView
import view.OutputView

fun main() {
    val game = RaceGame(OutputView(), InputView())
    game.run()
}
