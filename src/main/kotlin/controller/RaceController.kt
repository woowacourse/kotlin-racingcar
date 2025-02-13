package controller

import model.Car
import java.util.Random

class RaceController(
    private val count: Int,
    private val cars: MutableList<Car>,
    private val inOutController: InOutController,
) {
    fun fullRace() {
        inOutController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }

    private fun oneRace() {
        for (car in cars) {
            car.moveCar(Random())
        }
        inOutController.printCurrentPosition(cars)
    }

    fun getFinalResult(): MutableList<Car> {
        return comparePosition()
    }

    fun comparePosition(): MutableList<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }.toMutableList()
        return winnerList
    }
}
