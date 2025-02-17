package racingcar.model

import racingcar.enums.MoveState
import racingcar.util.ErrorConstants.ERROR

class Game(
    private val cars: List<Car>,
    private val randomNumberFactory: RandomNumberFactory,
) {
    init {
        validateUniqueName(cars.map { it.name })
    }

    fun playRound() {
        cars.forEach { car ->
            val moveState = MoveState.create(randomNumberFactory())
            car.moveCarWhenMovable(moveState)
        }
    }

    fun getRoundResult(): List<RoundResult> {
        return cars.map { car ->
            RoundResult(car.name, car.position)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        return winners
    }

    private fun validateUniqueName(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size) { NOT_UNIQUE_NAME_ERROR }
    }

    companion object {
        const val NOT_UNIQUE_NAME_ERROR = "$ERROR 자동차 이름이 중복됩니다."
    }
}
