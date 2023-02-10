package controller

import model.Car
import service.RacingCarGameService
import view.InputView
import view.OutputView

class RacingGameController(
    private var carsInfo: List<Car> = listOf(),
    private var tryCount: Int = DEFAULT_TRY_COUNT,
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
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
            outputView.printCar()
            val carsName = racingCarGameService.splitCarNames(inputView.inputName())
            carsInfo = racingCarGameService.initCarsInfo(carsName)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            inputCarNames()
        }
    }

    fun inputTryCount() {
        try {
            outputView.printTryCount()
            tryCount = inputView.inputTryCount().toInt()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            inputTryCount()
        }
    }

    fun playRound() {
        carsInfo = racingCarGameService.moveCars(carsInfo)

        outputView.printRoundResult(racingCarGameService.getRoundResult(carsInfo))
    }

    fun playWholeRacing() {
        outputView.printRunResultMessage()
        repeat(tryCount - 1) {
            playRound()
        }
    }

    fun outputWinner() {
        val winnerInfo = racingCarGameService.getMaxPositionCars(carsInfo)
        val winnerNames = racingCarGameService.getWinners(winnerInfo)
        outputView.printWinner(winnerNames)
    }

    companion object {
        const val DEFAULT_TRY_COUNT = 0
    }
}
