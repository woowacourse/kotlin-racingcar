package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Count
import racingcar.view.*

class RacingGame {
    fun play() {
        showNameInputMessage()
        val cars = tryMakeCars()

        showCountInputMessage()
        val count: Count = tryMakeCount()

        val winners = playTurn(cars, count)

        showWinners(winners)
    }

    private fun playTurn(cars: Cars, count: Count): List<Car> {
        for (i in 1..count.value) {
            cars.moveAll()
            showCarsPosition(cars)
        }
        return cars.findWinners()
    }

    private fun tryMakeCount(): Count {
        return try {
            makeCount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            tryMakeCount()
        }
    }

    private fun makeCount() = Count(readln().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요."))

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