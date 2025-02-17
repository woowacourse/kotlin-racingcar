package racingcar.domain

class Race(rawCarNames: String, rawTryCount: String) {
    val tryCount = rawTryCount.toInt()
    val cars = getCars(rawCarNames)

    fun getPositions(): List<List<Int>> {
        val generateRandomNumber = GenerateRandomNumber()
        val roundResults = mutableListOf<List<Int>>()
        repeat(tryCount) {
            cars.forEach { car ->
                val randomNumber = generateRandomNumber.randomNumber()
                car.moves(randomNumber)
            }
            roundResults.add(cars.map { it.position })
        }
        return roundResults
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.position }
        val winners =
            cars.filter { car ->
                car.position == maxNumber
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
