package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.readNames
import racingcar.view.showCarsPosition
import racingcar.view.showCountInputMessage
import racingcar.view.showNameInputMessage

class RacingGame {
    fun play() {
        showNameInputMessage()
        val cars = Cars(readNames().map { Car(it) })

        showCountInputMessage()
        val count: Int = readln().toIntOrNull()?: throw IllegalArgumentException()

        for (i in 1..count) {
            cars.moveAll()
            showCarsPosition(cars)
        }

        val winners = cars.findWinners()
        println("${winners.joinToString { car -> car.name }}가 최종 우승했습니다.")
    }
}