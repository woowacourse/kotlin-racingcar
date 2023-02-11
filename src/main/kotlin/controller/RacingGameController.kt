package controller

import model.Car
import service.RacingCarGameService
import view.InputView
import view.OutputView

class RacingGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCarGameService: RacingCarGameService
) {
    private var carsInfo = listOf<Car>()
    private var tryCount = 0

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
        val roundResult = racingCarGameService.getRoundResult(carsInfo)
        outputView.printRoundResult(roundResult)
    }

    fun playWholeRacing() {
        outputView.printRunResultMessage()
        for (round in 1..tryCount) playRound()
    }

    fun gerWinner() {
        val winners = racingCarGameService.getWinners(carsInfo)
        val winnersOutput = racingCarGameService.getWinnersOutput(winners)
        outputView.printWinner(winnersOutput)
    }
}
