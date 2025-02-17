package model

class Cars(
    private val carNames: List<String>,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    val parsedCars: List<Car> = carNames.map { Car(it) }

    init {
        validateCars()
    }

    fun playOneRound() {
        parsedCars.forEach { car ->
            car.moveForward(numberGenerator.generate())
        }
    }

    fun getWinner(): List<String> {
        val maxPosition = parsedCars.maxOf { it.position }
        val winners = parsedCars.filter { it.position == maxPosition }.map { it.name }

        return winners
    }

    override fun toString(): String {
        return buildString {
            parsedCars.forEach { car ->
                append(car.name)
                append(" : ")
                append("-".repeat(car.position))
                append("\n")
            }
        }
    }

    private fun validateCars() {
        require(carNames.distinct().size == carNames.size) { "자동차 이름 중 중복이 존재합니다.: $carNames" }
        require(carNames.size >= MINIMUM_CAR_COUNT) { "자동차가 2대 미만 입력되었습니다.: $carNames" }
    }

    companion object {
        private const val MINIMUM_CAR_COUNT = 2
    }
}
