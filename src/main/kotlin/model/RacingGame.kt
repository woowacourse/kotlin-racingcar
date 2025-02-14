package model

class RacingGame(
    private val generator: RandomNumberGenerator,
    private val cars: List<Car>,
) {
    fun tryRacing(rawCount: String): String {
        require(rawCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }

        return repeatRacing(rawCount.toInt())
    }

    fun getWinners(): List<String> {
        return cars.filter { it.position == cars.maxOf { car -> car.position } }
            .map { it.name }
    }

    private fun repeatRacing(count: Int): String {
        val result = StringBuilder("실행 결과\n")

        repeat(count) {
            raceOneRound()
            result.append(getRaceState()).append("\n")
        }

        return result.toString()
    }

    private fun raceOneRound() {
        cars.forEach { it.tryForward(generator.generate()) }
    }

    private fun getRaceState(): String = cars.joinToString("\n") { "${it.name} : ${FORWARD_SIGN.repeat(it.position)}" }

    private companion object {
        const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
        const val FORWARD_SIGN = "-"
    }
}
