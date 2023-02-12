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
    fun run() {
        val carsInfo = getCarNames()
        val tryCount = getTryCount()
        playWholeRound(tryCount, carsInfo)
        printWinner(gerWinner(carsInfo))
    }

    fun getCarNames(): List<Car> {
        return try {
            outputView.printCar()
            val input = inputView.inputName()
            val carsName = racingCarGameService.splitCarNames(input.name)
            racingCarGameService.initCarInfo(carsName)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            getCarNames()
        }
    }

    fun getTryCount(): Int {
        return try {
            outputView.printTryCount()
            val input = inputView.inputTryCount()
            input.tryCount.toInt()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            getTryCount()
        }
    }

    fun playRound(carsInfo: List<Car>): String {
        val carsInfo = racingCarGameService.moveCars(carsInfo)
        return racingCarGameService.getRoundResult(carsInfo)
    }

    fun printRoundResult(roundResultOutput: String) = outputView.printRoundResult(roundResultOutput)

    fun playWholeRound(tryCount: Int, carsInfo: List<Car>) {
        outputView.printRunResultMessage()
        repeat(tryCount) {
            printRoundResult(playRound(carsInfo))
        }
    }

    fun gerWinner(carsInfo: List<Car>): String {
        val winners = racingCarGameService.getWinners(carsInfo)
        return racingCarGameService.getWinnersOutput(winners)
    }

    fun printWinner(winnersOutput: String) {
        outputView.printWinner(winnersOutput)
    }
}
