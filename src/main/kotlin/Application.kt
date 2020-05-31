import view.InputView
import view.OutputView

fun main() {
    OutputView.askNumberOfCar()
    val numberOfCars = InputView.inputNumber()
    OutputView.askNumberOfRound()
    val numberOfRounds = InputView.inputNumber()

    val racingGame = RacingGame(numberOfCars, numberOfRounds)
    val roundDto = racingGame.playGame()
    OutputView.showResult(roundDto)
}

