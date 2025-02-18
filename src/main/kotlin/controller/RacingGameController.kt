package controller

import constant.RacingGameOutputConstant
import domain.Car
import domain.GameResult
import domain.RoundResult
import validator.RacingGameValidator
import view.InputView
import view.OutputView

class RacingGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val validator = RacingGameValidator()

    fun startRacingGameProgram() {
        val cars: List<Car> = getCarName().map { Car(it) }
        val count: Int = getTryCount()
        val roundResult = RoundResult(cars)
        executeRacing(roundResult, count)
        val gameResult = GameResult(cars)
        val winnerList: List<Car> = gameResult.getFinalResult()
        printFinalResult(winnerList)
    }

    fun getCarName(): List<String> {
        val input = inputView.getUserInput(RacingGameOutputConstant.INPUT_NAME)
        val carNames = splitToComma(input)
        validator.validateName(carNames)
        return carNames
    }

    private fun splitToComma(input: String): List<String> {
        val carNames = input.split(",").filter { it.isNotEmpty() }
        return carNames
    }

    fun getTryCount(): Int {
        val input = inputView.getUserInput(RacingGameOutputConstant.INPUT_COUNT)
        val count = parseInt(input)
        validator.validateCount(count)
        return count!!
    }

    private fun parseInt(input: String): Int? {
        val count = input.toIntOrNull()
        return count
    }

    private fun executeRacing(
        roundResult: RoundResult,
        count: Int,
    ) {
        printGameResult()
        repeat(count) {
            roundResult.runEachCar()
            val currentPositions: List<String> = roundResult.getRoundResult()
            printCurrentPositions(currentPositions)
        }
    }

    private fun printCurrentPositions(currentPositions: List<String>) {
        currentPositions.forEach {
            outputView.printCurrentResult(it)
        }
        println()
    }

    private fun printGameResult() {
        outputView.printGameResult()
    }

    fun printFinalResult(winnerResult: List<Car>) {
        outputView.printFinalResult(winnerResult)
    }
}
