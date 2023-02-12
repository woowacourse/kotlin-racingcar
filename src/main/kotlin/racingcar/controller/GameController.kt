package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.raceresult.toDto
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    fun runGame() {
        val cars = Cars(input.inputCarNames())
        val racingCount = input.inputRacingCount()
        val raceResult = raceManager.race(cars, racingCount)
        output.printRaceResult(raceResult.toDto())
        output.printWinner(raceManager.getWinners(cars))
    }
}
