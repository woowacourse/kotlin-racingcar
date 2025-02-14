package model

import util.Constants
import view.OutputView

class Cars {
    val cars = mutableSetOf<Car>()

    fun add(car: Car) {
        cars.add(car)
    }

    fun playRound() {
        cars.forEach { car ->
            val randomNumber = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            car.move(randomNumber)
            OutputView.printRound(car)
        }
    }

    fun getWinners(): Cars {
        val winners = Cars()
        val max = cars.maxOf { it.position }
        winners.cars.addAll(cars.filter { it.position == max })
        return winners
    }
}
