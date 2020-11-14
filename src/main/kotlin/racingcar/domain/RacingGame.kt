package racingcar.domain

object RacingGame {
    fun start(cars: Cars, tryCount: TryCount): MutableCollection<RacingHistory> {
        val gameResult: MutableCollection<RacingHistory> = ArrayList()

        while (tryCount.isPresent) {
            cars.go().toCollection(gameResult)
            tryCount.minus()
        }

        return gameResult
    }
}
