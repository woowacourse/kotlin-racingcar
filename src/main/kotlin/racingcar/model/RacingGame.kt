package racingcar.model

class RacingGame(
    private val generator: NumberGenerator,
) {
    private lateinit var racingCars: List<Car>

    fun generateCars(carNames: List<String>) {
        racingCars = carNames.map { Car(it.trim()) }
    }

    fun tryRacing(
        count: Int,
        printCurrentCarStep: (String) -> Unit,
    ) {
        repeat(count) {
            tryRacingOnce(printCurrentCarStep)
            printCurrentCarStep("")
        }
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
    }
}
