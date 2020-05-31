package domain.car

import utils.RandomGenerator
import view.dto.PositionsDto

class Cars(
    val cars: List<Car>
) {
    fun moveAll() {
        cars.forEach { it.move(RandomGenerator.generateRandom()) }
    }

    fun getPositionsDto(): PositionsDto {
        return PositionsDto(cars.map { it.position.position })
    }
}