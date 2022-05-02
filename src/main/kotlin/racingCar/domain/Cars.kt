package racingCar.domain

import racingCar.domain.move.MoveStrategy

data class Cars(val cars: List<Car>) {

    fun getWinners(): List<String> {
        return cars.filter { it.position == getMaxPosition() }.map { it.name.toString() }
    }

    private fun getMaxPosition(): Position {
        return cars.maxOfOrNull { it.position } ?: throw NoSuchElementException()
    }

    fun moveCars(moveStrategy: MoveStrategy) {
        cars.forEach { it.move(moveStrategy) }
    }

    companion object {
        fun from(carNames: List<Name>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
