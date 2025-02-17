package controller

import domain.Car

class RacingController() {
    fun playRace(cars: List<Car>) {
        for (car in cars) {
            if (car.isMovable(getRandomNumber())) {
                car.move()
            }
        }
    }

    fun getWinners(cars: List<Car>): List<String> {
        return cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name }
    }

    private fun getRandomNumber(): Int {
        return (MIN_RANGE..MAX_RANGE).random()
    }

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
    }
}
