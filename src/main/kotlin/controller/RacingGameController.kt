package controller

import model.Car
import model.Name
import model.TryCount
import service.RacingCarGameService
import validation.NameValidation
import validation.TryCountValidation
import view.InputViewInterface
import view.OutputViewInterface

class RacingGameController(
    private val nameValidation: NameValidation,
    private val tryCountValidation: TryCountValidation,
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

    private fun getCarNames(): Name {
        val name = inputView.inputName()
        nameValidation.checkNames(name).onSuccess { name ->
            return name
        }.onFailure { error ->
            outputView.printErrorMessage(error.message)
            return getCarNames()
        }.also { result ->
            return result.getOrThrow()
        }
    }

    private fun getCarsInfo(carNames: String): List<Car> {
        val carNamesSplit = racingCarGameService.splitCarNames(carNames)
        return racingCarGameService.initCarInfo(carNamesSplit)
    }

    private fun getTryCount(): TryCount {
        val tryCount = inputView.inputTryCount()
        tryCountValidation.checkTryCount(tryCount).onSuccess { tryCount ->
            return tryCount
        }.onFailure { error ->
            outputView.printErrorMessage(error.message)
            return getTryCount()
        }.also { result ->
            return result.getOrThrow()
        }
    }

    private fun playRound(carsInfo: List<Car>): String {
        val carsInfo = racingCarGameService.moveCars(carsInfo)
        return racingCarGameService.getRoundResult(carsInfo)
    }

    private fun printRoundResult(roundResultOutput: String) = outputView.printRoundResult(roundResultOutput)

    private fun playWholeRound(tryCount: Int, carsInfo: List<Car>): String {
        outputView.printRunResultMessage()
        var roundResult = ""
        repeat(tryCount) {
            roundResult += playRound(carsInfo)
            roundResult += "\n"
        }
        return roundResult
    }

    private fun gerWinner(carsInfo: List<Car>): List<String> {
        val winnersInfo = racingCarGameService.getWinnersInfo(carsInfo)
        return racingCarGameService.getWinnerNames(winnersInfo)
    }

    private fun printWinner(winners: List<String>) {
        outputView.printWinner(winners)
    }
}
