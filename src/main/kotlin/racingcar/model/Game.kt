package racingcar.model

import racingcar.enums.MoveState

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
            car.increasePositionIfMovable(moveState)
        }
    }

    fun getRoundResult(): String {
        return cars.map { car ->
            RoundResult(car.name, car.position)
        }.joinToString("\n")
    }

    fun getWinners(): String {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        val winnersMsg = winners.joinToString(", ")
        return winnersMsg
    }

    private fun validateUniqueName(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size) { NOT_UNIQUE_NAME_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val NOT_UNIQUE_NAME_ERROR = "$ERROR 자동차 이름이 중복됩니다."
    }
}
