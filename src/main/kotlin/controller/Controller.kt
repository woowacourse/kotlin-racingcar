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
        return runCatching {
            CarsFactory(inputView.readCars()).makeCars(RandomNumberGenerator())
        }.getOrElse { e ->
            outputView.printError(e.message ?: "")
            setUpCars()
        }
    }

    private fun setUpRaceTime(): Int {
        return runCatching {
            inputView.readRaceTime().getRaceTime()
        }.getOrElse { e ->
            outputView.printError(e.message ?: "")
            setUpRaceTime()
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
            car.race()
            outputView.printRaceResult(car.name, car.distance)
        }
    }

    private fun announceWinners(cars: List<Car>) {
        val winners = Judgement(cars).findWinners()
        outputView.printWinners(winners)
    }
}
