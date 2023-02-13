package racingcar.model.car

import racingcar.utils.random.RandomGenerator

class Cars(_cars: List<Car>) : List<Car> by _cars {
    init {
        validateExistDuplicatedCarName()
    }

    private fun validateExistDuplicatedCarName() {
        val nonDuplicatedCarsForName = this.distinctBy { it.carName.value }

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

    companion object {
        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."
    }
}
