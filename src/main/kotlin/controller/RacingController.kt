package controller

import domain.Car
import utils.MoveConditionGenerator.getMoveConditionByNumber

class RacingController() {
    fun playRace(cars: List<Car>) {
        for (car in cars) {
            car.moveOrStop(getMoveConditionByNumber((MIN_RANGE..MAX_RANGE).random()))
        }
    }

    fun getWinners(cars: List<Car>): List<String> {
        return cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name }
    }

    companion object {
        private const val DELIMITER = ','
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
    }
}
