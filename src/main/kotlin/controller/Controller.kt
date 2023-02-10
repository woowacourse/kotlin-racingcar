package controller

import domain.Car
import domain.CarsFactory
import domain.Judgement
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private var time = 0

    fun run() {
        val cars = setUpCars()
        setUpRaceTime()
        race(cars)
        announceWinners(cars)
    }

    private fun setUpCars(): List<Car> {
        while (true) {
            try {
                return CarsFactory(inputView.readCars()).makeCars(RandomNumberGenerator())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "")
            }
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

    private fun race(cars: List<Car>) {
        outputView.printExecutionResult()
        repeat(time) {
            raceOneTime(cars)
            outputView.printInterval()
        }
    }

    private fun raceOneTime(cars: List<Car>) {
        cars.forEach { car ->
            outputView.printRaceResult(car.race())
        }
    }

    private fun announceWinners(cars: List<Car>) {
        val winnersDTO = Judgement(cars).findWinners()
        outputView.printWinners(winnersDTO)
    }
}
