package racingcar.domain

import racingcar.domain.strategy.RandomMoveStrategy

class RacingGame {
    private val cars: MutableList<Car> = mutableListOf()
    private var raceCount: Int = 0

    fun initializeCars(carNames: List<String>) {
        carNames.forEach { cars.add(Car(it)) }
    }

    fun initializeRaceCount(raceCount: String) {
        this.raceCount = raceCount.toIntOrNull() ?: throw IllegalArgumentException("입력이 정수가 아닙니다.")
    }

    fun doWholeRace() {
        repeat(raceCount) { doSingleRace() }
    }

    private fun doSingleRace() {
        cars.forEach { it.moveByStrategy(RandomMoveStrategy()) }
    }
}
