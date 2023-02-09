package racingcar.model

import racingcar.entity.Name

class RacingManager {
    private val carManager = CarManager(mutableListOf())
    private lateinit var attemptCount: AttemptCount

    fun initCars(names: List<Name>) {
        carManager.init(names)
    }

    fun setAttemptCount(attemptCount: Int) {
        this.attemptCount = AttemptCount(attemptCount)
    }

    fun determineWinner() = carManager.determineWinner()

    fun run(): String {
        val result = mutableListOf<String>()
        for (i in attemptCount.indices) {
            result.add(carManager.attempt())
        }
        return makeRunLog(result)
    }

    fun makeRunLog(result: List<String>) = result.joinToString("\n\n")
}
