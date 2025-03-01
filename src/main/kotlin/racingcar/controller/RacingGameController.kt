package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarNameValidator
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val carNames = inputView.insertCarNames()
        CarNameValidator().validateCarName(carNames)
        val cars = carNames.map { Car(it) }

        val tryCount = inputView.insertTryCount() ?: throw IllegalArgumentException("[ERROR] 시도횟수를 다시 입력해주세요.")

        outputView.printResultMessage()
        printGameResult(Race(cars), tryCount)
    }

    private fun printGameResult(
        race: Race,
        tryCount: Int,
    ) {
        val carNames = race.cars.map { it.carName }
        repeat(tryCount) {
            val roundPositions = race.getPositions()
            outputView.printRoundResult(carNames, roundPositions)
        }
        outputView.printWinners(race.getWinners())
    }
}
