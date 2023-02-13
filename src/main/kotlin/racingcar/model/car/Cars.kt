package racingcar.model.car

import racingcar.dto.car.CarDto
import racingcar.utils.mapper.toDto
import racingcar.utils.mapper.toModel
import racingcar.utils.random.RandomGenerator

class Cars(_cars: List<Car>) : List<Car> by _cars {
    init {
        validateExistDuplicatedCarName()
    }

    private fun validateExistDuplicatedCarName() {
        val nonDuplicatedCarsForName = this.distinctBy { it.carName.name }

        require(this.size == nonDuplicatedCarsForName.size) {
            DUPLICATED_CAR_NAME_ERROR_MESSAGE
        }
    }

    fun moveAllRandomly(movementProbabilityGenerator: RandomGenerator): Cars = this.onEach { car ->
        val moveProbability = movementProbabilityGenerator.generate()
        car.moveRandomly(moveProbability)
    }

    fun getWinners(): Winners {
        val winnerStandard = this.maxBy { it.position }
        return Winners(this.filter { it.position == winnerStandard.position })
    }

    fun toDto(): CarsDto = CarsDto(
        this.map { car -> car.toDto() }
    )

    companion object {
        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."
    }
}

class CarsDto(_cars: List<CarDto>) : List<CarDto> by _cars {
    fun toModel(): Cars = Cars(this.map { it.toModel() })
}
