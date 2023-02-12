import domain.AdvanceCount
import domain.Car
import domain.GameCars
import domain.RandomMovingStrategy
import view.InputView
import view.OutputView

private lateinit var gameCars: GameCars
private lateinit var advanceCount: AdvanceCount

fun main() {
    setUpGameCars()
    setUpAdvanceCount()
    runGame()
    printGameResult()
}

private fun setUpGameCars() {
    OutputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)

    while (true) {
        runCatching {
            val carNames = InputView.readCarNames()
            val cars = carNames.map { Car(it, RandomMovingStrategy()) }
            gameCars = GameCars(cars)
        }
            .onSuccess { return }
            .onFailure { println(it.message) }
    }
}

private fun setUpAdvanceCount() {
    OutputView.printMessage(ADVANCE_COUNT_REQUEST_MESSAGE)

    while (true) {
        runCatching {
            val count = InputView.readAdvanceCount()
            advanceCount = AdvanceCount(count)
        }
            .onSuccess { return }
            .onFailure { println(it.message) }
    }
}

private fun runGame() {
    OutputView.printMessage(GAME_RESULT_HEADER)

    repeat(advanceCount.value) {
        gameCars.advanceAllCars()
        OutputView.printGameStatus(gameCars.cars)
    }
}

private fun printGameResult() {
    val winCars: List<Car> = gameCars.getMostAdvancedCars()
    OutputView.printGameResult(winCars)
}

private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val ADVANCE_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val GAME_RESULT_HEADER = "실행 결과"
