import common.ADVANCE_COUNT_REQUEST_MESSAGE
import common.CAR_NAMES_REQUEST_MESSAGE
import common.GAME_RESULT_HEADER
import domain.Car
import domain.CarRacingGameManager
import domain.RandomMovingStrategy
import view.InputView
import view.OutputView

fun main() {
    OutputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
    val carNames: List<String> = InputView.readCarNames()
    val cars = carNames.map { Car(it) }

    OutputView.printMessage(ADVANCE_COUNT_REQUEST_MESSAGE)
    val advanceCount: Int = InputView.readAdvanceCount()

    OutputView.printMessage(GAME_RESULT_HEADER)
    val racingGameManager = CarRacingGameManager(cars, RandomMovingStrategy())
    repeat(advanceCount) {
        racingGameManager.allCarsTryToMoveForward()
        OutputView.printGameStatus(cars)
    }

    val winCars: List<Car> = racingGameManager.getWinCars()
    OutputView.printGameResult(winCars)
}
