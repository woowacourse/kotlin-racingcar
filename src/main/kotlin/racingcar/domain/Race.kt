package racingcar.domain

class Race(rawCarNames: String, rawTryCount: String) {
    val tryCount = rawTryCount.toInt()
    val cars = getCars(rawCarNames)

    fun getPositions() {
        val generateRandomNumber = GenerateRandomNumber()
        repeat(tryCount) {
            cars.forEach { car ->
                val randomNumber = generateRandomNumber.randomNumber()
                car.moves(randomNumber)
            }
        }
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.moveCount() }
        val winners =
            cars.filter { car ->
                car.moveCount() == maxNumber
            }.map { it.carName }
        return winners
    }

    private fun getCars(rawCarNames: String): List<Car> {
        return rawCarNames.split(COMMA).map { Car(it.trim()) }
    }

    companion object {
        private const val COMMA = ","
    }
}
