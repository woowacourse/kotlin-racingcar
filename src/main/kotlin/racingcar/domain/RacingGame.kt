package racingcar.domain

import racingcar.domain.car.Cars

class RacingGame(val cars: Cars, private var laps: Laps) {

    fun isEnd(): Boolean {
        return laps.isEnd()
    }

    fun race() {
        cars.moveCars()
        laps = laps.next()
    }

    fun winner(): Cars {
        return cars.findWinners()
    }
}