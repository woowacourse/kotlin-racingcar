package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

class RacingGame(
    carNames: List<String>,
    private val moveStrategy: MoveStrategy,
) {
    private val cars: MutableList<Car> = mutableListOf()

    init {
        validateAndTrimCarNames(carNames).forEach { cars.add(Car(it)) }
    }

    fun getWinCarNames(): List<String> = getWinCars().map { it.name }

    private fun getWinCars(): List<Car> =
        cars.filter { car ->
            car.distance == cars.maxOf { it.distance }
        }

    fun doWholeRace(
        rounds: Int,
        onEachRound: (Map<String, Int>) -> Unit,
    ) {
        validateNaturalNumber(rounds)
        repeat(rounds) {
            onEachRound(doSingleRace()) // 매 경기 결과 콜백
        }
    }

    private fun doSingleRace(): Map<String, Int> {
        val singleRaceInfo: MutableMap<String, Int> = mutableMapOf()
        cars.forEach {
            it.moveByStrategy(moveStrategy)
            singleRaceInfo[it.name] = it.distance
        }
        return singleRaceInfo
    }

    companion object {
        private fun validateAndTrimCarNames(carNames: List<String>): List<String> {
            val trimmedCarNames = trimCarNames(carNames)
            require(trimmedCarNames.distinct().size == trimmedCarNames.size) { ERROR_DUPLICATE_NAME }
            return trimmedCarNames
        }

        private fun trimCarNames(carNames: List<String>) = carNames.map { carName -> carName.trim() }

        private const val ERROR_DUPLICATE_NAME = "중복된 자동차 이름이 존재합니다."

        private fun validateNaturalNumber(number: Int) {
            require(number > 0) { "입력이 자연수가 아닙니다." }
        }
    }
}
