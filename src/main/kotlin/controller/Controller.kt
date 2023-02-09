package controller

import domain.Car
import domain.Judgement
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private val cars = mutableListOf<Car>()
    private val judgement = Judgement(cars)
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
            val carsDTO = inputView.readCars()
            carsDTO.getCars().map { car -> cars.add(car) }
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
        cars.map { car ->
            outputView.printRaceResult(car.race())
        }
    }

    private fun announceWinners() {
        val winnersDTO = judgement.findWinners()
        outputView.printWinners(winnersDTO)
    }
}
