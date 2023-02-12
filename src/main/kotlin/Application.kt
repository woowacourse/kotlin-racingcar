import controller.RaceGame
import view.InputView
import view.OutputView

fun main() {
    val game = RaceGame(InputView(), OutputView())
    game.run()
}
