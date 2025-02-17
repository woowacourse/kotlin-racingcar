package model

import controller.RaceController

class RaceGame(
    private val count: Int,
    private val cars: MutableList<Car>,
) {
    fun fullRace(): List<List<Car>> {
        val raceResults = mutableListOf<List<Car>>()
        repeat(count) {
            oneRace()
            raceResults.add(cars.toList())
        }
        return raceResults
    }

    private fun oneRace() {
        for (car in cars) {
            car.moveCar()
        }
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
