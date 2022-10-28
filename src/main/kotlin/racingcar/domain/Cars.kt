package racingcar.domain

import java.lang.IllegalArgumentException

class Cars(
    val cars: List<Car>,
    private val strategy: MovingStrategy = RandomStrategy()
) {

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(
                carNames.map { Car(it)}
            )
        }
    }

    fun moveAll() {
        for (car in cars) {
            if (strategy.isMovable()) {
                car.moveForward(strategy)
            }
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        println(maxPosition.value)
        return cars.filter {
            it.isSamePosition(maxPosition)
        }
    }

    private fun findMaxPosition(): Position {
        return cars.map {
            it.position
        }.maxByOrNull { it.value } ?: throw IllegalArgumentException("제일 앞선 차가 없습니다.")
    }
}
