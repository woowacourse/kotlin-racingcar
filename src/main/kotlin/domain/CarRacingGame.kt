package domain

import data.Car

class CarRacingGame(
    private val referee: Referee = Referee()
) {

    fun moveCarsOneCycle(cars: List<Car>) = cars.forEach { car ->
        car.move()
    }

    fun getWinners(cars: List<Car>) = referee.judgeWinners(cars)
}
