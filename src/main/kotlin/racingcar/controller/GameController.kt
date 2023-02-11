package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.racingcar.domain.CarFactory
import racingcar.racingcar.domain.raceresult.RaceResultMapper
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
    private val raceResultMapper: RaceResultMapper = RaceResultMapper(),
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    private var carFactory = CarFactory(listOf())
    private var racingCount = 0

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        carFactory = CarFactory(input.inputCarNames())
        racingCount = input.inputRacingCount()
    }

    private fun startGame() {
        val raceResult = raceManager.race(carFactory, racingCount)
        output.printRaceResult(raceResultMapper.toRaceResultDto(raceResult))
    }

    private fun endGame() {
        output.printWinner(raceManager.getWinners(carFactory))
    }
}
