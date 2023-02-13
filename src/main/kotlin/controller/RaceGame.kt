package controller

import generator.RandomGenerator
import model.Cars
import util.CarsHelper
import view.InputView
import view.OutputView

class RaceGame(private val outputView: OutputView, private val inputView: InputView) {

    fun run() {
        outputView.outputCarNames()
        val cars = Cars(inputView.inputCarNames())
        outputView.outputTryNumber()
        val tryNumber = inputView.inputTryNumber().toInt()
        outputView.outputResults()
        repeat(tryNumber) {
            tryMove(cars)
        }
        outputView.outputWinners(CarsHelper.findWinners(cars))
    }

    private fun tryMove(cars: Cars) {
        repeat(cars.getCarSize()) {
            cars.move(it, RandomGenerator().getRandomNumber())
            outputView.outputResult(cars.getCar(it))
        }
        outputView.outputNextLine()
    }
}
