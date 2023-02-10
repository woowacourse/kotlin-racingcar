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
        getCarNames()
        getTryCount()
        playWholeRacing()
        gerWinner()
    }

    fun getCarNames() {
        try {
            outputView.printCar()
            val carsName = racingCarGameService.splitCarNames(inputView.inputName())
            carsInfo = racingCarGameService.initCarInfo(carsName)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            getCarNames()
        }
    }

    fun getTryCount() {
        try {
            outputView.printTryCount()
            tryCount = inputView.inputTryCount().toInt()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            getTryCount()
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

    fun gerWinner() {
        outputView.printWinner(racingCarGameService.getWinners(racingCarGameService.getMaxPositionCars(carsInfo)))
    }
}
