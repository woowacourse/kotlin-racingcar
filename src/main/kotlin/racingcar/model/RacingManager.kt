package racingcar.model

import racingcar.entity.AttemptCount

class RacingManager(private val carManager: CarManager, private val attemptCount: AttemptCount) {
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
        return makeAttemptLog()
    }

    fun makeAttemptLog() = carManager.toString()

    fun step(index: Int, number: Int) {
        carManager.step(index, number)
    }
}
