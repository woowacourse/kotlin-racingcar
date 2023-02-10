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

private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val ADVANCE_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val GAME_RESULT_HEADER = "실행 결과"
