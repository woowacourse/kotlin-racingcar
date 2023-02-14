package racingcar.model.car

import racingcar.model.car.move.condition.CarMoveCondition
import racingcar.model.car.move.step.OneStep
import racingcar.model.car.move.step.ZeroStep

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

    fun moveAll(carMoveCondition: CarMoveCondition): Cars = this.onEach { car ->
        if (isSatisfyCondition(carMoveCondition)) {
            car.move(OneStep)
        } else {
            car.move(ZeroStep)
        }
    }

    private fun isSatisfyCondition(carMoveCondition: CarMoveCondition) =
        carMoveCondition() >= MOVE_CONDITION

    fun getWinners(): Winners {
        val winnerStandard = this.maxBy { it.position }
        return Winners(this.filter { it.position == winnerStandard.position })
    }

    companion object {
        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."
        private const val MOVE_CONDITION = 4
    }
}
