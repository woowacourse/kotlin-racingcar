package racingcar.domain

class Cars(val cars: List<Car>, private val strategy: MovingStrategy = RandomMovingStrategy()) {

    init {
        require(cars.distinct().size == cars.size) { "자동차 이름에 중복이 있습니다." }
    }

    fun move(): Cars {
        return Cars(
            cars.map { it.moveForward(strategy) },
            strategy
        )
    }

    fun findWinners(): List<Car> {
        return cars.filter { it.isSamePosition(findMaxPosition()) }
    }

    private fun findMaxPosition(): Position {
        return cars.maxOfOrNull { it.position } ?: throw IllegalArgumentException("최대 위치를 찾을 수 없습니다.")
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(
                carNames.map { Car(it) }
            )
        }
    }
}
