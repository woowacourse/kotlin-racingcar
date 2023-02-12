package controller

import model.Cars
import util.CarsHelper
import view.InputView
import view.OutputView

class RaceGame(private val outputView: OutputView, private val inputView: InputView) {

    fun run() {
        outputView.outputCarNames()
        val cars = executeInputCarNames()
        outputView.outputTryNumber()
        val tryNumber = executeInputTryNumber()
        outputView.outputResults()
        repeat(tryNumber) {
            tryMove(cars)
        }
        outputView.outputWinners(CarsHelper.findWinners(cars))
    }

    private fun tryMove(cars: Cars) {
        repeat(cars.getCarSize()) {
            cars.move(it)
            outputView.outputResult(cars.getCar(it))
        }
        outputView.outputNextLine()
    }

    private fun executeInputTryNumber(): Int = inputView.inputTryNumber().toInt()
    private fun executeInputCarNames(): Cars = Cars(inputView.inputCarNames())
}
