package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.racingcar.view.InputInterface
import racingcar.racingcar.view.OutputInterface

class GameController(
    private val raceManager: RaceManager,
    private val inputInterface: InputInterface,
    private val outputInterface: OutputInterface
) {

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        raceManager.setGame(inputInterface.inputCarNames(), inputInterface.inputRacingCount())
    }

    private fun startGame() {
        val result = raceManager.race()
        outputInterface.printRaceResult(result)
    }

    private fun endGame() {
        outputInterface.printWinner(raceManager.getWinner())
    }
}
