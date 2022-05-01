package racingcar.domain

import java.util.stream.Collectors

class Cars(val cars: List<Car>, private val strategy: MovingStrategy = RandomMovingStrategy()) {

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(
                carNames.stream()
                    .map { Car(it) }
                    .collect(Collectors.toList()),
            )
        }
    }

    init {
        require(cars.toSet().size == cars.size) { "자동차 이름에 중복이 있습니다." }
    }

    fun move(): Cars {
        return Cars(cars.stream()
            .map { it.moveForward(strategy) }
            .collect(Collectors.toList()), strategy)
    }

    fun findWinners(): List<Car> {
        return cars.stream()
            .filter { it.isSamePosition(findMaxPosition()) }
            .collect(Collectors.toList())
    }

    private fun findMaxPosition(): Position {
        return cars.stream()
            .map { it.position }
            .sorted()
            .findFirst()
            .orElseThrow { IllegalStateException("최대 위치를 찾을 수 없습니다.") }
    }
}
