package controller

import model.Car
import model.Name
import model.TryCount
import service.RacingCarGameService
import validation.NameValidationResult
import validation.TryCountValidationResult
import view.InputViewInterface
import view.OutputViewInterface

class RacingGameController(
    private val inputView: InputViewInterface,
    private val outputView: OutputViewInterface,
    private val racingCarGameService: RacingCarGameService
) {
    fun run() {
        val carNames = getCarNames().name
        val carsInfo = getCarsInfo(carNames)
        val tryCount = getTryCount().tryCount.toInt()
        printRoundResult(playWholeRound(tryCount, carsInfo))
        printWinner(gerWinner(carsInfo))
    }

    fun getCarNames(): Name {
        outputView.printCar()
        val input = inputView.inputName()
        val carNames = runCatching { checkCarNamesInput(input) }.getOrNull()
        return carNames ?: getCarNames()
    }

    fun checkCarNamesInput(result: NameValidationResult): Name? {
        return when (result) {
            is NameValidationResult.Failure -> returnNullNameWithErrorMessage(result.errorMessage)
            is NameValidationResult.Success -> result.name
        }
    }

    fun returnNullNameWithErrorMessage(errorMessage: String): Name? {
        outputView.printErrorMessage(errorMessage)
        return null
    }

    fun getCarsInfo(carNames: String): List<Car> {
        val carNamesSplit = racingCarGameService.splitCarNames(carNames)
        return racingCarGameService.initCarInfo(carNamesSplit)
    }

    fun getTryCount(): TryCount {
        outputView.printTryCount()
        val input = inputView.inputTryCount()
        val tryCount = runCatching { checkTryCountInput(input) }.getOrNull()
        return tryCount ?: getTryCount()
    }

    fun checkTryCountInput(result: TryCountValidationResult): TryCount? {
        return when (result) {
            is TryCountValidationResult.Failure -> printTryCountErrorMessage(result.errorMessage)
            is TryCountValidationResult.Success -> result.tryCount
        }
    }

    fun printTryCountErrorMessage(errorMessage: String): TryCount? {
        println(errorMessage)
        return null
    }

    fun playRound(carsInfo: List<Car>): String {
        val carsInfo = racingCarGameService.moveCars(carsInfo)
        return racingCarGameService.getRoundResult(carsInfo)
    }

    fun printRoundResult(roundResultOutput: String) = outputView.printRoundResult(roundResultOutput)

    fun playWholeRound(tryCount: Int, carsInfo: List<Car>): String {
        outputView.printRunResultMessage()
        var roundResult = ""
        repeat(tryCount) {
            roundResult += playRound(carsInfo)
            roundResult += "\n"
        }
        return roundResult
    }

    fun gerWinner(carsInfo: List<Car>): List<String> {
        val winnersInfo = racingCarGameService.getWinnersInfo(carsInfo)
        return racingCarGameService.getWinnerNames(winnersInfo)
    }

    fun printWinner(winners: List<String>) {
        outputView.printWinner(winners)
    }
}
