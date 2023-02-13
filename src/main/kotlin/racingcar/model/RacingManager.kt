package racingcar.model

import racingcar.entity.Name

class RacingManager(names: List<Name>, private val attemptCount: AttemptCount) {
    private val carManager = CarManager(names, RandomNumber)

    fun determineWinner() = carManager.determineWinner()

    fun run(): String {
        val result = mutableListOf<String>()
        for (i in attemptCount.indices) {
            result.add(attempt())
        }
        return makeRunLog(result)
    }

    fun makeRunLog(result: List<String>) = result.joinToString("\n\n")

    private fun attempt(): String {
        carManager.attempt()
        return carManager.makeAttemptLog()
    }

    fun makeAttemptLog() = carManager.toString()
}
