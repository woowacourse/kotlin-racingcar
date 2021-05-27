package racingcar.domain

import racingcar.domain.car.Cars

class RacingGame(private var cars: Cars, private val laps: Laps) {

    private val history = mutableListOf(cars)

    fun race() {
        var laps = laps
        while (!laps.isEnd()) {
            cars = cars.moveCars()
            history.add(cars)
            laps = laps.next()
        }
    }

    fun winner(): Cars {
        return cars.findWinners()
    }

    fun history(): List<Cars> {
        return history.toList()
    }
}