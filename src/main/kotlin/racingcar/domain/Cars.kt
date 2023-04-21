package racingcar.domain

class Cars(
    val cars: List<Car>,
) {

    fun moveAll(numberGenerator: NumberGenerator) {
        for (car in cars) {
            car.move(numberGenerator.generate())
        }
    }

    fun findWinningCars(): List<Car> {
        val maxPosition = findMaxPosition() ?: throw IllegalArgumentException("포지션이 존재하지 않습니다.")
        return cars.filter { it.isSamePosition(maxPosition) }
    }

    private fun findMaxPosition(): Int? {
        return cars.maxOfOrNull { it.position }
    }
}
