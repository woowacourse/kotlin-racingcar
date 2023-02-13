import domain.AdvanceCount
import domain.Car
import domain.GameCars
import view.InputView
import view.OutputView

fun main() {
    val gameCars = getGameCars()
    val advanceCount = getAdvanceCount()
    runGame(gameCars, advanceCount)
    printGameResult(gameCars)
}

private fun getGameCars(): GameCars {
    OutputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)

    return InputView.getGameCars()
}

private fun getAdvanceCount(): AdvanceCount {
    OutputView.printMessage(ADVANCE_COUNT_REQUEST_MESSAGE)

    return InputView.getAdvanceCount()
}

private fun runGame(gameCars: GameCars, advanceCount: AdvanceCount) {
    OutputView.printMessage(GAME_RESULT_HEADER)

    repeat(advanceCount.value) {
        gameCars.advanceAllCars()
        OutputView.printGameStatus(gameCars.cars.toList())
    }
}

private fun printGameResult(gameCars: GameCars) {
    val winCars: List<Car> = gameCars.getMostAdvancedCars()
    OutputView.printGameResult(winCars)
}

private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val ADVANCE_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val GAME_RESULT_HEADER = "\n실행 결과"
