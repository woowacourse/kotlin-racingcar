package controller

import domain.Car
import domain.CarsFactory
import domain.Judgement
import domain.RaceTime
import domain.RandomNumberGenerator
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val cars = createCars()
        val raceTime = getRaceTime()
        race(cars, raceTime)
        announceWinners(cars)
    }

    private fun createCars(): List<Car> {
        return runCatching {
            CarsFactory(inputView.readCarNames()).makeCars(RandomNumberGenerator())
        }.getOrElse { e ->
            outputView.printError(e.message ?: "")
            createCars()
        }
    }

    private fun getRaceTime(): RaceTime {
        return runCatching {
            RaceTime(inputView.readRaceTime())
        }.getOrElse { e ->
            outputView.printError(e.message ?: "")
            getRaceTime()
        }
    }

    private fun race(cars: List<Car>, raceTime: RaceTime) {
        outputView.printExecutionResult()
        while (raceTime.reduceTime()) {
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
