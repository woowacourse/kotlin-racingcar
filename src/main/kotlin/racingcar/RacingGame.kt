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
        val cars = tryMakeCars()

        showCountInputMessage()
        val count: Int = tryMakeCount()

        for (i in 1..count) {
            cars.moveAll()
            showCarsPosition(cars)
        }

        val winners = cars.findWinners()
        println("${winners.joinToString { car -> car.name }}가 최종 우승했습니다.")
    }

    private fun tryMakeCount(): Int {
        return try {
            makeCount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            tryMakeCount()
        }
    }

    private fun makeCount() = readln().toIntOrNull() ?: throw IllegalArgumentException("1~1000 사이의 숫자를 입력해주세요.")

    private fun tryMakeCars(): Cars {
        return try {
            makeCars()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            tryMakeCars()
        }
    }

    private fun makeCars() = Cars(readNames().map { Car(it) })
}