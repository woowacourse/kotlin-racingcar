package controller

import generator.RandomGenerator
import model.Cars
import util.Constants
import util.WinnersFinder
import view.InputView
import view.OutputView

class RaceGame(private val outputView: OutputView, private val inputView: InputView) {

    fun run() {
        outputView.outputCarNames()
        val cars = Cars(inputCarNames())
        outputView.outputNumber()
        val tryNumber = inputNumber().toInt()
        outputView.outputResults()
        repeat(tryNumber) {
            tryMove(cars)
        }
        outputView.outputWinners(WinnersFinder.findWinners(cars))
    }

    private fun tryMove(cars: Cars) {
        repeat(cars.getCarSize()) {
            cars.move(it, RandomGenerator().getRandomNumber())
            outputView.outputResult(cars.getCar(it))
        }
        outputView.outputNextLine()
    }

    private fun inputCarNames(): String {
        var input = inputView.inputCarNames()
        while (input.isNullOrBlank() || input.contains("[ERROR]")) {
            outputView.outputErrorMessage(input ?: Constants.INPUT_IS_NULL)
            input = inputView.inputCarNames()
        }
        return input
    }

    private fun inputNumber(): String {
        var input = inputView.inputNumber()
        while (input.isNullOrBlank() || input.contains("[ERROR]")) {
            outputView.outputErrorMessage(input ?: Constants.INPUT_IS_NULL)
            input = inputView.inputNumber()
        }
        return input
    }
}
