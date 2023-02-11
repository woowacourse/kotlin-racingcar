package domain.game

import model.Car

class CarRacingGame(
    private val referee: CarRacingGameReferee = CarRacingGameReferee()
) {

    fun moveCarsOneCycle(cars: List<Car>) = cars.forEach { car ->
        car.move()
    }

    fun getWinners(cars: List<Car>) = referee.judgeWinners(cars)
}
