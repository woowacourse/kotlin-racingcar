package racingcar.model

import racingcar.util.RandomGenerator

class Race(
    val raceCars: Cars,
    private val raceCount: Int,
    private val randomGenerator: RandomGenerator,
) {
    private var round = MIN_RACE_COUNT

    init {
        validateRaceCount(raceCount)
    }

    private fun validateRaceCount(count: Int) {
        require(count >= MIN_RACE_COUNT) { "[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다." }
    }

    fun proceed() {
        val conditions = randomGenerator.getRandomConditions(raceCars.cars.size)

        raceCars.moveCars(conditions)
        round++
    }

    fun isNotEnd(): Boolean = round <= raceCount

    companion object {
        private const val MIN_RACE_COUNT = 1
    }
}
