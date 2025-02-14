package controller

import model.Car
import java.util.Random

class RaceController(
    private val count: Int,
    private val cars: List<Car>,
    private val viewController: ViewController,
) {
    fun fullRace() {
        viewController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }

    private fun oneRace() {
        for (car in cars) {
            car.moveCar(Random())
        }
        viewController.printCurrentPosition(cars)
    }

    fun getFinalResult(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }
        return winnerList
    }
}
