package racingcar.domain

import racingcar.domain.car.Cars

class RacingGame(private var cars: Cars, private var laps: Laps) {

    private val history = mutableListOf(cars)

    fun race() {
        while (!laps.isEnd()) {
            cars = cars.moveCars()
            laps = laps.next()

            history.add(cars)
        }
    }

    fun winner(): Cars {
        return cars.findWinners()
    }

    fun history(): List<Cars> {
        return history.toList()
    }
}