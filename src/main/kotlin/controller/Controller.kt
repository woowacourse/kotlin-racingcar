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
        var completeSetUpCar = false
        var completeSetUpRaceTime = false
        while (!completeSetUpCar) {
            completeSetUpCar = setUpCars()
        }
        while (!completeSetUpRaceTime) {
            completeSetUpRaceTime = setUpRaceTime()
        }
        outputView.printInterval()
    }

    private fun setUpCars(): Boolean {
        return try {
            val carNamesDTO = inputView.readCarNames()
            cars = Cars(generator, carNamesDTO.getCarNames())
            true
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: "")
            false
        }
    }

    private fun setUpRaceTime(): Boolean {
        return try {
            time = inputView.readRaceTime().getRaceTime()
            true
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: "")
            false
        }
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
