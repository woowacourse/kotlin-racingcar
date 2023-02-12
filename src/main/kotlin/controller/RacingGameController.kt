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
        inputCarNames()
        inputTryCount()
        playWholeRacing()
        outputWinner()
    }

    fun inputCarNames() {
        try {
            OutputView.printCar()
            val carsName = racingCarGameService.splitCarNames(InputView.inputName())
            carsInfo = racingCarGameService.initCarsInfo(carsName)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            inputCarNames()
        }
    }

    fun inputTryCount() {
        try {
            OutputView.printTryCount()
            tryCount = InputView.inputTryCount().toInt()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            inputTryCount()
        }
    }

    fun playRound() {
        carsInfo = racingCarGameService.moveCars(carsInfo)

        OutputView.printRoundResult(racingCarGameService.getRoundResult(carsInfo))
    }

    fun playWholeRacing() {
        OutputView.printRunResultMessage()
        repeat(tryCount - 1) {
            playRound()
        }
    }

    fun outputWinner() {
        val winnerInfo = racingCarGameService.getMaxPositionCars(carsInfo)
        val winnerNames = racingCarGameService.getWinners(winnerInfo)
        OutputView.printWinner(winnerNames)
    }

    companion object {
        private const val DEFAULT_TRY_COUNT = 0
    }
}
