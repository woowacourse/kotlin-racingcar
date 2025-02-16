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

    private fun validateCars() {
        require(carNames.distinct().size == carNames.size) { "자동차 이름 중 중복이 존재합니다." }
        require(carNames.size > 1) { "자동차가 2대 미만 입력되었습니다." }
    }
}
