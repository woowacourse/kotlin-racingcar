package controller

import model.Car

class RaceController(
    private val count: Int,
    private val cars: MutableList<Car>,
    private val outController: OutController,
) {
    fun fullRace() {
        outController.printGameResult()
        repeat(count) {
            oneRace()
        }
    }

    private fun oneRace() {
        for (car in cars) {
            car.moveCar()
        }
        outController.printCurrentPosition(cars)
    }

    fun getFinalResult(): MutableList<Car> {
        return comparePosition()
    }

    private fun comparePosition(): MutableList<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }.toMutableList()
        return winnerList
    }
}
