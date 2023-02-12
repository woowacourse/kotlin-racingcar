package controller

import model.Car
import service.RacingCarGameService
import view.InputView
import view.OutputView

class RacingGameController(
    private var carsInfo: List<Car> = listOf(),
    private var tryCount: Int = DEFAULT_TRY_COUNT,
    private val racingCarGameService: RacingCarGameService = RacingCarGameService()
) {

    fun run() {
        try {
            inputCarNames()
            inputTryCount()
            playWholeRacing()
            outputWinner()
        } catch (e: IllegalArgumentException) {
            OutputView.printMessage(e.message!!)
        }
    }

    private fun inputCarNames() {
        val carsName = racingCarGameService.splitCarNames(InputView.inputName())
        carsInfo = racingCarGameService.initCarsInfo(carsName)
    }

    private fun inputTryCount() {
        tryCount = InputView.inputTryCount().toInt()
    }

    private fun playRound() {
        carsInfo = racingCarGameService.moveCars(carsInfo)

        OutputView.printRoundResult(carsInfo)
    }

    private fun playWholeRacing() {
        OutputView.printRunResultMessage()
        repeat(tryCount) {
            playRound()
        }
    }

    private fun outputWinner() {
        val winnerInfo = racingCarGameService.getMaxPositionCars(carsInfo)
        OutputView.printWinners(winnerInfo)
    }

    companion object {
        private const val DEFAULT_TRY_COUNT = 0
    }
}
