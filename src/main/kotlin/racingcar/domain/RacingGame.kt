package racingcar.domain

import racingcar.domain.strategy.NumberGenerator

class RacingGame(cars: Cars, trialCount: Int) {

    val cars: Cars
    var trialCount: Int
        private set

    init {
        this.cars = cars
        this.trialCount = trialCount.also {
            if (trialCount <= 0) throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다")
        }
    }

    companion object {

        fun initGame(carNames: List<String>, trialCount: Int): RacingGame {
            return RacingGame(Cars.from(carNames), trialCount)
        }
    }

    fun play(numberGenerator: NumberGenerator) {
        if (isEnd()) throw IllegalAccessException("남은 시도 횟수가 없습니다")
        cars.moveAll(numberGenerator)
        trialCount--
    }

    fun isEnd(): Boolean {
        return trialCount <= 0
    }

    fun getWinners(): List<Car> {
        return cars.getWinners()
    }
}
