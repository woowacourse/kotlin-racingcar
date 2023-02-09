import common.ADVANCE_COUNT_REQUEST_MESSAGE
import common.CAR_NAMES_REQUEST_MESSAGE
import common.GAME_RESULT_HEADER
import domain.Car
import domain.CarRacingGameManager
import domain.RandomMovingStrategy
import view.InputView
import view.OutputView

fun main() {
    val cars = askCarNames()

    val advanceCount: Int = askAdvanceCount()

    val gameManager = CarRacingGameManager(cars, RandomMovingStrategy())

    runGame(cars, advanceCount, gameManager)

    printGameResult(gameManager)
}

private fun askCarNames(): List<Car> {
    OutputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
    val carNames: List<String> = InputView.readCarNames()
    return carNames.map { Car(it) }
}

private fun askAdvanceCount(): Int {
    OutputView.printMessage(ADVANCE_COUNT_REQUEST_MESSAGE)
    return InputView.readAdvanceCount()
}

private fun runGame(cars: List<Car>, advanceCount: Int, gameManager: CarRacingGameManager) {
    OutputView.printMessage(GAME_RESULT_HEADER)
    repeat(advanceCount) {
        gameManager.allCarsTryToMoveForward()
        OutputView.printGameStatus(cars)
    }
}

private fun printGameResult(gameManager: CarRacingGameManager) {
    val winCars: List<Car> = gameManager.getWinCars()
    OutputView.printGameResult(winCars)
}
