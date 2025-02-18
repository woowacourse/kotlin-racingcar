package racingcar.model

class RacingGame(
    private val generator: NumberGenerator,
) {
    private lateinit var racingCars: List<Car>

    fun generateCars(carNames: List<String>) {
        validateCarNames(carNames)
        racingCars = carNames.map { Car(it.trim()) }
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.size > RACING_CAR_MIN_SIZE) { INVALID_CAR_SIZE_MESSAGE }
        require(carNames.size == carNames.distinct().size) { DUPLICATE_CAR_NAME_MESSAGE }
    }

    fun tryRacing(
        count: String,
        printCurrentCarStep: (String) -> Unit,
    ) {
        validateRacingCount(count)
        repeat(count.toInt()) {
            tryRacingOnce(printCurrentCarStep)
            printCurrentCarStep("")
        }
    }

    private fun validateRacingCount(count: String) {
        require(count.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }
    }

    private fun tryRacingOnce(printCurrentCarStep: (String) -> Unit) {
        racingCars.forEach { car ->
            tryForward(car)
            printCurrentCarStep(prettyCarStep(car))
        }
    }

    private fun tryForward(car: Car) = car.tryForward(generator.generate(MIN_VALUE, MAX_VALUE))

    private fun prettyCarStep(car: Car): String = "${car.name} : ${STEP_MARK.repeat(car.step)}"

    fun calculateWinner(): String {
        val maxValue = racingCars.maxOf { it.step }
        return racingCars.filter { it.step == maxValue }.joinToString(WINNER_SEPARATOR) { it.name }
    }

    private companion object {
        const val STEP_MARK = "-"
        const val WINNER_SEPARATOR = ", "
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
        private const val INVALID_CAR_SIZE_MESSAGE = "레이싱 게임은 두대 이상이어야 합니다."
        private const val DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름이 중복됩니다."
        private const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
        private const val RACING_CAR_MIN_SIZE = 1
    }
}
