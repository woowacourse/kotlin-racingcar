package controller

import model.Car
import service.RacingCarGameService
import view.InputView
import view.OutputView

class RacingGameController(
    private var carsInfo: List<Car> = listOf(),
    private var tryCount: Int = 0,
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
        for (round in 1..tryCount) playRound()
    }

    fun outputWinner() {
        outputView.printWinner(racingCarGameService.getWinners(racingCarGameService.getMaxPositionCars(carsInfo)))
    }
}
