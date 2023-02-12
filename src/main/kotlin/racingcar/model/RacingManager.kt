package racingcar.model

import racingcar.entity.Name

class RacingManager {
    private val carManager = CarManager()
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
            result.add(attempt())
        }
        return makeRunLog(result)
    }

    fun makeRunLog(result: List<String>) = result.joinToString("\n\n")

    fun attempt(): String {
        carManager.attempt()
        return carManager.makeAttemptLog()
    }

    fun makeAttemptLog() = carManager.toString()

    fun step(index: Int, number: Int) {
        carManager.step(index, number)
    }
}
