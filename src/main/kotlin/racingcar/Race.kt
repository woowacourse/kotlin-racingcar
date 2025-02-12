package racingcar

class Race(val carNames: String, rawTryCount: String) {
    private val tryCount = rawTryCount.toInt()
    private val cars = carNames.split(",").map { Car(it) }

    private fun isMove(randomNumber: Int): Boolean {
        return randomNumber in 3..9
    }

    fun moveOrStops() {
        val generateRandomNumber = GenerateRandomNumber()
        repeat(tryCount) {
            cars.forEach { car ->
                val randomNumber = generateRandomNumber.randomNumber()
                car.moves(isMove(randomNumber))
            }
        }
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.moveCount() }
        val winners = cars.filter { car ->
            car.moveCount() == maxNumber
        }.map { it.carName }
        return winners
    }
}
