package model

class RacingGame(
    private val generator: RandomNumberGenerator,
) {
    private lateinit var racingCars: List<Car>

    fun generateCars(rawCars: String) {
        racingCars = rawCars.split(DELIMITER).map { Car(it.trim()) }

        require(racingCars.size > RACING_CAR_MIN_SIZE) { INVALID_CAR_SIZE_MESSAGE }
        require(racingCars.size == racingCars.map { it.name }.distinct().size) { DUPLICATE_CAR_NAME_MESSAGE }
    }

    fun tryRacing(rawCount: String): String {
        require(rawCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }

        return repeatRacing(rawCount.toInt())
    }

    fun calculateWinner(): String {
        val maxValue = racingCars.maxOf { it.getStep().length }
        return racingCars.filter { it.getStep().length == maxValue }.joinToString(WINNER_SEPARATOR) { it.name }
    }

    private fun repeatRacing(count: Int): String {
        val result = StringBuilder("실행 결과")

        repeat(count) {
            racingCars.forEach {
                it.tryForward(generator.generate(MIN_VALUE, MAX_VALUE))
                result.append("\n${it.name} : ${it.getStep()}")
            }
            result.append("\n")
        }
        return result.toString()
    }

    private companion object {
        const val INVALID_CAR_SIZE_MESSAGE = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름이 중복됩니다."
        const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
        const val DELIMITER = ","
        const val WINNER_SEPARATOR = ", "
        const val RACING_CAR_MIN_SIZE = 1
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
    }
}
