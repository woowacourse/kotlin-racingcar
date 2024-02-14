package racingcar.controller

import racingcar.model.Car

class FinalWinner {

    fun decideWinner(cars: List<Car>): List<String> {
        val winnersPosition = cars.maxOf { it.position.length }

        return cars.filter { it.position.length == winnersPosition }.map { it.name }
    }
}
