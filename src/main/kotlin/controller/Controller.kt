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
        val carNames = inputView.readCarNames().getCarNames()
        cars = Cars(generator, carNames)
    }

    private fun setUpRaceTime() {
        time = inputView.readRaceTime().getRaceTime()
    }

    private fun race() {
        outputView.printExecutionResult()
        for (t in 0 until time) {
            raceOneTime()
            outputView.printInterval()
        }
    }

    private fun raceOneTime() {
        val raceOneTimeResults = cars.raceOneTime()
        raceOneTimeResults.map { result ->
            outputView.printRaceResult(result)
        }
    }

    private fun announceWinners() {
        val winnersDTO = cars.findWinners()
        outputView.printWinners(winnersDTO)
    }
}
