package racingcar.domain

class Cars(val cars: List<Car>, private val strategy: MovingStrategy = RandomMovingStrategy()) {
    companion object {
        fun from(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }

    init {
        require(cars.distinct().size == cars.size) { "자동차 이름에 중복이 있습니다." }
    }

    fun move(): Cars {
        return Cars(cars.map { it.moveForward(strategy) })
    }

    fun findWinners(): List<Car> {
        return cars.filter { it.isSamePosition(findMaxPosition()) }
    }

    private fun findMaxPosition(): Position {
        return cars
            .map { it.position }
            .maxOrNull() ?: throw IllegalStateException("최대 위치를 찾을 수 없습니다.")
    }
}
