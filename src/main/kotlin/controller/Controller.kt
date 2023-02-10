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

    fun run() {
        val cars = setUpCars()
        val raceTime = setUpRaceTime()
        race(cars, raceTime)
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

    private fun setUpRaceTime(): Int {
        while (true) {
            try {
                return inputView.readRaceTime().getRaceTime()
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "")
            }
        }
    }

    private fun race(cars: List<Car>, raceTime: Int) {
        outputView.printExecutionResult()
        repeat(raceTime) {
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
