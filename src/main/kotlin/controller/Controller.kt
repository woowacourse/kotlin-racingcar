package controller

import domain.Cars
import domain.NumberGenerator
import view.InputView
import view.OutputView

class Controller(
    private val generator: NumberGenerator,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var cars: Cars
    private var time = 0

    fun run() {
        setUp()
        race()
        announceWinners()
    }

    private fun setUp() {
        setUpCars()
        setUpRaceTime()
        outputView.printInterval()
    }

    private fun setUpCars() {
        val carNames = inputView.readCarNames().names
        cars = Cars(generator, carNames)
    }

    private fun setUpRaceTime() {
        time = inputView.readRaceTime().time
    }

    private fun race() {
        outputView.printExecutionResult()
        repeat(time) {
            raceOneTime()
            outputView.printInterval()
        }
    }

    private fun raceOneTime() {
        val raceOneTimeResults = cars.raceOneTime()
        raceOneTimeResults.forEach { result ->
            outputView.printRaceResult(result)
        }
    }

    private fun announceWinners() {
        val winners = cars.findWinners()
        outputView.printWinners(winners)
    }
}
