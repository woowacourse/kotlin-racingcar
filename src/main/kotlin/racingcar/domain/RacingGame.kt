package racingcar.domain

import racingcar.domain.strategy.RandomMoveStrategy

class RacingGame(
    carNames: List<String>,
    raceCountText: String,
) {
    private val cars: MutableList<Car> = mutableListOf()
    private var raceCount: Int = 0
    val raceInfo: MutableList<Map<String, Int>> = mutableListOf()

    init {
        raceCount = validateAndParseRaceCount(raceCountText)
        carNames.forEach { cars.add(Car(it)) }
    }

    fun getWinCarNames(): List<String> = getWinCars().map { it.name }

    private fun getWinCars(): List<Car> =
        cars.filter { car ->
            car.distance == cars.maxOf { it.distance }
        }

    fun doWholeRace() {
        repeat(raceCount) { doSingleRace() }
    }

    private fun doSingleRace() {
        val singleRaceInfo: MutableMap<String, Int> = mutableMapOf()
        cars.forEach {
            it.moveByStrategy(RandomMoveStrategy())
            singleRaceInfo[it.name] = it.distance
        }
        raceInfo.add(singleRaceInfo)
    }

    companion object {
        private fun validateAndParseRaceCount(raceCountText: String): Int {
            val number = parseToInt(raceCountText)
            validateNaturalNumber(number)
            return number
        }

        private fun parseToInt(text: String): Int = text.toIntOrNull() ?: throw IllegalArgumentException("입력이 숫자가 아닙니다.")

        private fun validateNaturalNumber(number: Int) {
            require(number > 0) { "입력이 자연수가 아닙니다." }
        }
    }
}
